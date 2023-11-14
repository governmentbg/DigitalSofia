package com.digitall.digital_sofia.utils

import com.digitall.digital_sofia.domain.models.common.AppLanguage
import com.digitall.digital_sofia.domain.repository.common.PreferencesRepository
import com.digitall.digital_sofia.domain.utils.LogUtil.logDebug
import com.digitall.digital_sofia.extensions.readOnly
import java.util.Locale

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

class LocalizationManager(
    private val currentContext: CurrentContext,
    private val preferences: PreferencesRepository,
) {

    companion object {
        private const val TAG = "LocalizationManagerTag"
    }

    @Volatile
    private var inChange = false

    private val _readyLiveData = SingleLiveEvent<Unit>()
    val readyLiveData = _readyLiveData.readOnly()

    fun applyLanguage(
        language: AppLanguage? = null,
    ) {
        if (inChange) return
        inChange = true
        val newLanguage = if (language != null) {
            preferences.saveCurrentLanguage(language)
            language
        } else {
            preferences.readCurrentLanguage()
        }
        logDebug("applyLanguage language: ${newLanguage.type}", TAG)
        val languageStr = newLanguage.type
        val locale = Locale(languageStr)
        val configuration = currentContext.get().resources.configuration
        val displayMetrics = currentContext.get().resources.displayMetrics
        Locale.setDefault(locale)
        configuration.setLocale(locale)
        currentContext.get().createConfigurationContext(configuration)
        currentContext.get().resources.updateConfiguration(configuration, displayMetrics)
        _readyLiveData.call()
        inChange = false
    }
}