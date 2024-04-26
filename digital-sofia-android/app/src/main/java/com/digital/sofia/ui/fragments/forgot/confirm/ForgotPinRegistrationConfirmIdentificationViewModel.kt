package com.digital.sofia.ui.fragments.forgot.confirm

import androidx.annotation.StringRes
import androidx.lifecycle.viewModelScope
import com.digital.sofia.NavActivityDirections
import com.digital.sofia.R
import com.digital.sofia.domain.models.common.AppStatus
import com.digital.sofia.domain.repository.common.CryptographyRepository
import com.digital.sofia.domain.repository.common.PreferencesRepository
import com.digital.sofia.domain.usecase.firebase.UpdateFirebaseTokenUseCase
import com.digital.sofia.domain.usecase.logout.LogoutUseCase
import com.digital.sofia.domain.usecase.user.GetLogLevelUseCase
import com.digital.sofia.domain.utils.AuthorizationHelper
import com.digital.sofia.domain.utils.LogUtil.logDebug
import com.digital.sofia.extensions.navigateInMainThread
import com.digital.sofia.extensions.navigateNewRootInMainThread
import com.digital.sofia.models.common.StringSource
import com.digital.sofia.ui.fragments.base.registration.identification.BaseConfirmIdentificationViewModel
import com.digital.sofia.utils.AppEventsHelper
import com.digital.sofia.utils.EvrotrustSDKHelper
import com.digital.sofia.utils.FirebaseMessagingServiceHelper
import com.digital.sofia.utils.LocalizationManager
import com.digital.sofia.utils.LoginTimer
import com.digital.sofia.utils.NetworkConnectionManager
import com.digital.sofia.utils.UpdateDocumentsHelper

class ForgotPinRegistrationConfirmIdentificationViewModel(
    private val preferences: PreferencesRepository,
    loginTimer: LoginTimer,
    appEventsHelper: AppEventsHelper,
    evrotrustSDKHelper: EvrotrustSDKHelper,
    authorizationHelper: AuthorizationHelper,
    localizationManager: LocalizationManager,
    updateDocumentsHelper: UpdateDocumentsHelper,
    cryptographyRepository: CryptographyRepository,
    updateFirebaseTokenUseCase: UpdateFirebaseTokenUseCase,
    getLogLevelUseCase: GetLogLevelUseCase,
    networkConnectionManager: NetworkConnectionManager,
    firebaseMessagingServiceHelper: FirebaseMessagingServiceHelper,
) : BaseConfirmIdentificationViewModel(
    loginTimer = loginTimer,
    preferences = preferences,
    appEventsHelper = appEventsHelper,
    evrotrustSDKHelper = evrotrustSDKHelper,
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
        private const val TAG = "ForgotPinRegistrationConfirmIdentificationViewModelTag"
    }

    override fun toErrorFragment() {
        logDebug("toErrorFragment", TAG)
        findFlowNavController().navigateInMainThread(
            ForgotPinRegistrationConfirmIdentificationFragmentDirections.toErrorFragment(
                errorMessage = StringSource.Res(R.string.registration_error_description)
            ),
            viewModelScope
        )
    }

    override fun proceedNext() {
        logDebug("proceedNext", TAG)
        findFlowNavController().navigateInMainThread(
            ForgotPinRegistrationConfirmIdentificationFragmentDirections.toForgotPinShareYourDataFragment(),
            viewModelScope
        )
    }

    private fun toMainTabs() {
        preferences.saveAppStatus(AppStatus.REGISTERED)
        findActivityNavController().navigateNewRootInMainThread(
            NavActivityDirections.toMainTabsFlowFragment(),
            viewModelScope
        )
    }

    override fun toErrorFragment(@StringRes errorMessageRes: Int) {
        logDebug("toErrorFragment", TAG)
        findFlowNavController().navigateInMainThread(
            ForgotPinRegistrationConfirmIdentificationFragmentDirections.toErrorFragment(
                errorMessage = StringSource.Res(errorMessageRes)
            ),
            viewModelScope
        )
    }

    override fun onNoClicked() {
        logDebug("onNoClicked", TAG)
        findFlowNavController().navigateInMainThread(
            ForgotPinRegistrationConfirmIdentificationFragmentDirections.toErrorFragment(
                errorMessage = StringSource.Res(R.string.registration_error_description)
            ),
            viewModelScope
        )
    }
}