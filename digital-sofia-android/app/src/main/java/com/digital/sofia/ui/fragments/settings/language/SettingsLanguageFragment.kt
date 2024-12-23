/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.ui.fragments.settings.language

import android.widget.CompoundButton
import com.digital.sofia.R
import com.digital.sofia.databinding.FragmentLanguageBinding
import com.digital.sofia.domain.models.common.AppLanguage
import com.digital.sofia.domain.utils.LogUtil.logDebug
import com.digital.sofia.extensions.setTextResource
import com.digital.sofia.ui.fragments.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsLanguageFragment : BaseFragment<FragmentLanguageBinding, SettingsLanguageViewModel>() {

    companion object {
        private const val TAG = "SettingsLanguageFragmentTag"
    }

    override fun getViewBinding() = FragmentLanguageBinding.inflate(layoutInflater)

    override val viewModel: SettingsLanguageViewModel by viewModel()

    private val switchBgListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        logDebug("switchBgListener isChecked: $isChecked", TAG)
        val language = if (isChecked) AppLanguage.BG
        else AppLanguage.EN
        viewModel.changeLanguage(language)
    }

    private val switchEnListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        logDebug("switchEnListener isChecked: $isChecked", TAG)
        val language = if (isChecked) AppLanguage.EN
        else AppLanguage.BG
        viewModel.changeLanguage(language)
    }

    override fun onResume() {
        viewModel.onResume()
        super.onResume()
    }

    override fun setupControls() {
        binding.customToolbar.navigationClickListener = {
            logDebug("customToolbar navigationClickListener", TAG)
            onBackPressed()
        }
        binding.switchBg.setOnCheckedChangeListener(switchBgListener)
        binding.switchEn.setOnCheckedChangeListener(switchEnListener)
    }

    override fun subscribeToLiveData() {
        viewModel.currentLanguageLiveData.observe(this) {
            binding.switchBg.setOnCheckedChangeListener(null)
            binding.switchEn.setOnCheckedChangeListener(null)
            binding.switchBg.isChecked = it == AppLanguage.BG
            binding.switchEn.isChecked = it == AppLanguage.EN
            binding.switchBg.setOnCheckedChangeListener(switchBgListener)
            binding.switchEn.setOnCheckedChangeListener(switchEnListener)
        }
        viewModel.getReadyLiveData().observe(this) {
            binding.customToolbar.showNavigationText(R.string.back)
            binding.tvLangTitle.setTextResource(R.string.language_title)
        }
    }

}