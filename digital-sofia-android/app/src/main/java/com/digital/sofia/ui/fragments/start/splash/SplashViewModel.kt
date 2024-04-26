/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.ui.fragments.start.splash

import androidx.lifecycle.viewModelScope
import com.digital.sofia.BuildConfig
import com.digital.sofia.NavActivityDirections
import com.digital.sofia.R
import com.digital.sofia.data.DEBUG_FORCE_APP_STATUS
import com.digital.sofia.data.DEBUG_FORCE_ENTER_TO_ACCOUNT
import com.digital.sofia.data.DEBUG_LOGOUT_FROM_PREFERENCES
import com.digital.sofia.data.DEBUG_PRINT_FIREBASE_TOKEN
import com.digital.sofia.data.DEBUG_PRINT_PREFERENCES_INFO
import com.digital.sofia.domain.models.common.AppStatus
import com.digital.sofia.domain.models.common.SdkStatus
import com.digital.sofia.domain.repository.common.CryptographyRepository
import com.digital.sofia.domain.repository.common.PreferencesRepository
import com.digital.sofia.domain.usecase.firebase.UpdateFirebaseTokenUseCase
import com.digital.sofia.domain.usecase.logout.LogoutUseCase
import com.digital.sofia.domain.usecase.user.GetLogLevelUseCase
import com.digital.sofia.domain.utils.AuthorizationHelper
import com.digital.sofia.domain.utils.LogUtil.logDebug
import com.digital.sofia.domain.utils.LogUtil.logError
import com.digital.sofia.extensions.navigateNewRootInMainThread
import com.digital.sofia.models.common.Message
import com.digital.sofia.models.common.StringSource
import com.digital.sofia.ui.BaseViewModel
import com.digital.sofia.utils.AppEventsHelper
import com.digital.sofia.utils.EvrotrustSDKHelper
import com.digital.sofia.utils.FirebaseMessagingServiceHelper
import com.digital.sofia.utils.LocalizationManager
import com.digital.sofia.utils.LoginTimer
import com.digital.sofia.utils.NetworkConnectionManager
import com.digital.sofia.utils.UpdateDocumentsHelper

class SplashViewModel(
    private val preferences: PreferencesRepository,
    private val evrotrustSDKHelper: EvrotrustSDKHelper,
    loginTimer: LoginTimer,
    appEventsHelper: AppEventsHelper,
    authorizationHelper: AuthorizationHelper,
    localizationManager: LocalizationManager,
    updateDocumentsHelper: UpdateDocumentsHelper,
    cryptographyRepository: CryptographyRepository,
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
        private const val TAG = "SplashViewModelTag"
        private const val PREFERENCES_INFO_TAG = "PreferencesInfoTag"
    }

    override val isAuthorizationActive: Boolean = false

    override fun onFirstAttach() {
        if (BuildConfig.DEBUG && DEBUG_PRINT_FIREBASE_TOKEN) {
            logDebug("Firebase token:", TAG)
            logDebug("\n${preferences.readFirebaseToken()?.token}", TAG)
            logDebug("\n", TAG)
        }
        if (BuildConfig.DEBUG && DEBUG_FORCE_APP_STATUS != null) {
            preferences.saveAppStatus(DEBUG_FORCE_APP_STATUS!!)
        }
        if (BuildConfig.DEBUG && DEBUG_LOGOUT_FROM_PREFERENCES) {
            preferences.logoutFromPreferences()
            logDebug("logoutFromPreferences", TAG)
        }
        if (BuildConfig.DEBUG && DEBUG_PRINT_PREFERENCES_INFO) {
            logDebug("accessToken: ${preferences.readAccessToken()}", TAG)
            logDebug("refreshToken: ${preferences.readRefreshToken()}", TAG)
            val pinCode = preferences.readPinCode()
            logDebug("hashedPin: ${pinCode?.hashedPin}", PREFERENCES_INFO_TAG)
            logDebug("encryptedPin: ${pinCode?.encryptedPin}", PREFERENCES_INFO_TAG)
            val appStatus = preferences.readAppStatus()
            logDebug("appStatus: ${appStatus.name}", PREFERENCES_INFO_TAG)
            val user = preferences.readUser()
            logDebug("firstName: ${user?.firstName}", PREFERENCES_INFO_TAG)
            logDebug("lastName: ${user?.lastName}", PREFERENCES_INFO_TAG)
            logDebug("middleName: ${user?.middleName}", PREFERENCES_INFO_TAG)
            logDebug("phone: ${user?.phone}", PREFERENCES_INFO_TAG)
            logDebug("email: ${user?.email}", PREFERENCES_INFO_TAG)
            logDebug("securityContext: ${user?.securityContext}", PREFERENCES_INFO_TAG)
            logDebug(
                "personalIdentificationNumber: ${user?.personalIdentificationNumber}",
                PREFERENCES_INFO_TAG
            )
        }
    }

    fun onSdkStatusChanged(sdkStatus: SdkStatus) {
        val appStatus = preferences.readAppStatus()
        logDebug(
            "onSdkStatusChanged sdkStatus: ${sdkStatus.name} appStatus: ${appStatus.name}",
            TAG
        )
        val pinCode = preferences.readPinCode()
        val user = preferences.readUser()
        when (sdkStatus) {
            SdkStatus.SDK_SETUP_READY -> {
                logDebug("onSdkStatusChanged SDK_SETUP_READY", TAG)
                if (BuildConfig.DEBUG && DEBUG_FORCE_ENTER_TO_ACCOUNT) {
                    preferences.saveAppStatus(AppStatus.REGISTERED)
                    logDebug("onSdkStatusChanged DEBUG_FORCE_ENTER_TO_ACCOUNT", TAG)
                    toEnterCodeFragment()
                    return
                }
                if (appStatus != AppStatus.REGISTERED) {
                    logDebug("onSdkStatusChanged SDK_SETUP_READY toRegistrationFragment", TAG)
                    toRegistrationFragment()
                    return
                }
                if (pinCode == null) {
                    logError("onSdkStatusChanged SDK_SETUP_READY pinCode == null", TAG)
                    toRegistrationFragment()
                    return
                }
                if (!pinCode.validate()) {
                    logError("onSdkStatusChanged SDK_SETUP_READY pinCode not valid", TAG)
                    toRegistrationFragment()
                    return
                }
                if (user == null) {
                    logError("onSdkStatusChanged SDK_SETUP_READY user == null", TAG)
                    toRegistrationFragment()
                    return
                }
                if (!user.validate()) {
                    logError("onSdkStatusChanged SDK_SETUP_READY user not valid", TAG)
                    toRegistrationFragment()
                    return
                }
                evrotrustSDKHelper.checkUserStatus()
                return
            }

            SdkStatus.SDK_SETUP_ERROR,
            SdkStatus.CRITICAL_ERROR -> {
                logError("onSdkStatusChanged SDK_SETUP_ERROR or CRITICAL_ERROR", TAG)
                logout()
                return
            }

            SdkStatus.USER_SETUP_ERROR -> {
                logError("onSdkStatusChanged USER_SETUP_ERROR", TAG)
                preferences.saveAppStatus(AppStatus.NOT_REGISTERED)
                toRegistrationFragment()
                return
            }

            SdkStatus.USER_STATUS_NOT_IDENTIFIED -> {
                logError("onSdkStatusChanged USER_STATUS_NOT_IDENTIFIED", TAG)
                showMessage(
                    Message(
                        title = StringSource.Res(R.string.oops_with_dots),
                        message = StringSource.Text(
                            "User information is incomplete, you must update your user information to continue"
                        ),
                        type = Message.Type.ALERT,
                        positiveButtonText = StringSource.Res(R.string.ok),
                        negativeButtonText = StringSource.Res(R.string.cancel),
                    )
                )
            }

            SdkStatus.USER_STATUS_READY -> {
                logDebug("onSdkStatusChanged USER_STATUS_READY", TAG)
                if (appStatus != AppStatus.REGISTERED) {
                    logError("onSdkStatusChanged not ready", TAG)
                    toRegistrationFragment()
                    return
                }
                if (pinCode == null) {
                    logError("onSdkStatusChanged USER_STATUS_READY pinCode == null", TAG)
                    toRegistrationFragment()
                    return
                }
                if (!pinCode.validate()) {
                    logError("onSdkStatusChanged USER_STATUS_READY pinCode not valid", TAG)
                    toRegistrationFragment()
                    return
                }
                if (user == null) {
                    logError("onSdkStatusChanged USER_STATUS_READY user == null", TAG)
                    toRegistrationFragment()
                    return
                }
                if (!user.validate()) {
                    logError("onSdkStatusChanged USER_STATUS_READY user not valid", TAG)
                    toRegistrationFragment()
                    return
                }
                toEnterCodeFragment()
            }

            else -> {
                logError("onSdkStatusChanged SdkStatus else", TAG)
                showMessage(Message.error(R.string.error_user_not_setup_correct))
                toRegistrationFragment()
            }
        }
    }

    private fun toEnterCodeFragment() {
        logDebug("toEnterCodeFragment", TAG)
        findActivityNavController().navigateNewRootInMainThread(
            NavActivityDirections.toEnterCodeFlowFragment(),
            viewModelScope
        )
    }

}