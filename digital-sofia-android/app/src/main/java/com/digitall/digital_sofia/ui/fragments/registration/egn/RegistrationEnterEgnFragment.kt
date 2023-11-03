package com.digitall.digital_sofia.ui.fragments.registration.egn

import android.graphics.Paint
import androidx.core.view.isVisible
import com.digitall.digital_sofia.databinding.FragmentRegistrationEnterEgnBinding
import com.digitall.digital_sofia.domain.utils.LogUtil.logDebug
import com.digitall.digital_sofia.extensions.onClickThrottle
import com.digitall.digital_sofia.extensions.setTextChangeListener
import com.digitall.digital_sofia.ui.fragments.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

class RegistrationEnterEgnFragment :
    BaseFragment<FragmentRegistrationEnterEgnBinding, RegistrationEnterEgnViewModel>() {

    companion object {
        private const val TAG = "RegistrationEnterEgnFragmentTag"
    }

    override fun getViewBinding() = FragmentRegistrationEnterEgnBinding.inflate(layoutInflater)

    override val viewModel: RegistrationEnterEgnViewModel by viewModel()

    override fun setupView() {
        binding.tvConditions.paintFlags =
            binding.tvConditions.paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }

    override fun setupControls() {
        binding.checkBoxConditions.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setConditionsIsChecked(isChecked)
        }
        binding.etEgn.setTextChangeListener {
            viewModel.setPersonalIdentificationNumber(it.trim())
        }
        binding.tvConditions.onClickThrottle {
            logDebug("tvConditions onClickThrottle", TAG)
            viewModel.onConditionsClicked()
        }
        binding.btnNext.onClickThrottle {
            logDebug("btnNext onClickThrottle", TAG)
            viewModel.onNextClicked()
        }
    }

    override fun subscribeToLiveData() {
        viewModel.savedEgnLiveData.observe(viewLifecycleOwner) {
            binding.etEgn.setText(it)
        }
        viewModel.showEgnErrorLiveData.observe(viewLifecycleOwner) {
            binding.tvEgnError.isVisible = it == true
        }
        viewModel.showConditionsErrorLiveData.observe(viewLifecycleOwner) {
            binding.tvConditionsError.isVisible = it == true
        }
    }

}