/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.ui.fragments.settings.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.digital.sofia.NavActivityDirections
import com.digital.sofia.R
import com.digital.sofia.domain.repository.common.CryptographyRepository
import com.digital.sofia.domain.repository.common.PreferencesRepository
import com.digital.sofia.domain.usecase.firebase.UpdateFirebaseTokenUseCase
import com.digital.sofia.domain.usecase.logout.LogoutUseCase
import com.digital.sofia.domain.usecase.user.GetLogLevelUseCase
import com.digital.sofia.domain.utils.AuthorizationHelper
import com.digital.sofia.domain.utils.LogUtil.logDebug
import com.digital.sofia.domain.utils.LogUtil.logError
import com.digital.sofia.extensions.navigateInMainThread
import com.digital.sofia.extensions.readOnly
import com.digital.sofia.extensions.setValueOnMainThread
import com.digital.sofia.models.common.Message
import com.digital.sofia.ui.BaseViewModel
import com.digital.sofia.utils.AppEventsHelper
import com.digital.sofia.utils.FirebaseMessagingServiceHelper
import com.digital.sofia.utils.LocalizationManager
import com.digital.sofia.utils.LoginTimer
import com.digital.sofia.utils.NetworkConnectionManager
import com.digital.sofia.utils.SupportBiometricManager
import com.digital.sofia.utils.UpdateDocumentsHelper
import javax.crypto.Cipher

class SettingsAuthMethodViewModel(
    private val preferences: PreferencesRepository,
    private val biometricManager: SupportBiometricManager,
    private val cryptographyRepository: CryptographyRepository,
    loginTimer: LoginTimer,
    appEventsHelper: AppEventsHelper,
    authorizationHelper: AuthorizationHelper,
    localizationManager: LocalizationManager,
    updateDocumentsHelper: UpdateDocumentsHelper,
    updateFirebaseTokenUseCase: UpdateFirebaseTokenUseCase,
    getLogLevelUseCase: GetLogLevelUseCase,
    networkConnectionManager: NetworkConnectionManager,
    firebaseMessagingServiceHelper: FirebaseMessagingServiceHelper,
) : BaseViewModel(
    loginTimer = loginTimer,
    preferences = preferences,
    appEventsHelper = appEventsHelper,
    authorizationHelper = authorizationHelper,
    localizationManager = localizationManager,
    updateDocumentsHelper = updateDocumentsHelper,
    cryptographyRepository = cryptographyRepository,
    updateFirebaseTokenUseCase = updateFirebaseTokenUseCase,
    getLogLevelUseCase = getLogLevelUseCase,
    networkConnectionManager = networkConnectionManager,
    firebaseMessagingServiceHelper = firebaseMessagingServiceHelper,
) {

    companion object {
        private const val TAG = "AuthMethodViewModelTag"
    }

    override val isAuthorizationActive: Boolean = true

    private val _enableBiometricLiveData = MutableLiveData<Boolean>()
    val enableBiometricLiveData = _enableBiometricLiveData.readOnly()

    override fun onFirstAttach() {
        logDebug("onFirstAttach", TAG)
        _enableBiometricLiveData.setValueOnMainThread(biometricManager.readyToBiometricAuth())
    }

    fun enableBiometric(isEnabled: Boolean) {
        logDebug("enableBiometric isEnabled: $isEnabled", TAG)
        if (!isEnabled) {
            disableBiometric()
        } else {
            _enableBiometricLiveData.setValueOnMainThread(false)
            startBiometric()
        }
    }

    fun onBiometricTooManyAttempts() {
        logError("onBiometricTooManyAttempts", TAG)
        showMessage(Message.error(R.string.auth_biometric_scanner_many_attempts))
        _enableBiometricLiveData.setValueOnMainThread(false)
    }

    fun onBiometricError() {
        logError("onBiometricError", TAG)
        showMessage(Message.error(R.string.auth_biometric_scanner_failed))
        _enableBiometricLiveData.setValueOnMainThread(false)
    }

    private fun startBiometric() {
        logDebug("startBiometric", TAG)
        val cipher = cryptographyRepository.getBiometricCipherForEncryption()
        if (cipher == null) {
            logError("cipher == null", TAG)
            findActivityNavController().navigateInMainThread(
                NavActivityDirections.toBiometricErrorBottomSheetFragment(), viewModelScope
            )
            return
        }
        try {
            biometricManager.authenticate(cipher)
        } catch (e: Exception) {
            logError("handleStartBiometricAuth exception: ${e.message}", e, TAG)
            showMessage(Message.error(R.string.error_biometric))
            _enableBiometricLiveData.setValueOnMainThread(false)
        }
    }

    fun confirmFingerprint(cipher: Cipher?) {
        logDebug("confirmFingerprint", TAG)
        val pinCode = preferences.readPinCode()
        if (pinCode == null) {
            logError("confirmFingerprint pinCode == null", TAG)
            showMessage(Message.error(R.string.error_pin_code_not_setup))
            logout()
            return
        }
        if (!pinCode.validate()) {
            logError("confirmFingerprint !pinCode.validate()", TAG)
            showMessage(Message.error(R.string.error_pin_code_not_setup))
            logout()
            return
        }
        if (cipher == null) {
            logError("confirmFingerprint cipher == null", TAG)
            showMessage(Message.error(R.string.error_biometric))
            disableBiometric()
            _enableBiometricLiveData.setValueOnMainThread(false)
            return
        }
        try {
            val encryptedPin = cryptographyRepository.encrypt(pinCode.decryptedPin!!, cipher)
            logDebug(
                "confirmFingerprint pinCode.hashedPin: ${pinCode.hashedPin}\n" +
                        "pinCode.decryptedPin: ${pinCode.decryptedPin}\n" +
                        "pinCode.encryptedPin: ${pinCode.encryptedPin}\n" +
                        "encryptedPin: $encryptedPin", TAG
            )
            if (encryptedPin.isEmpty()) {
                logError("confirmFingerprint encryptedPin.isEmpty()", TAG)
                showMessage(Message.error(R.string.error_biometric))
                disableBiometric()
                _enableBiometricLiveData.setValueOnMainThread(false)
                return
            }
            enableBiometric(encryptedPin)
            _enableBiometricLiveData.setValueOnMainThread(true)
        } catch (e: Exception) {
            logError(e, TAG)
            showMessage(Message.error(R.string.error_biometric))
            disableBiometric()
            _enableBiometricLiveData.setValueOnMainThread(false)
        }
    }

}