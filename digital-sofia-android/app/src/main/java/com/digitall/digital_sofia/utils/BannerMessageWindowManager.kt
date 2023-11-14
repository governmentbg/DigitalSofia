package com.digitall.digital_sofia.utils

import android.content.Context
import android.content.res.Resources
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.digitall.digital_sofia.R
import com.digitall.digital_sofia.databinding.LayoutBannerViewBinding
import com.digitall.digital_sofia.domain.utils.LogUtil.logError
import com.digitall.digital_sofia.extensions.backgroundColor
import com.digitall.digital_sofia.extensions.onClickThrottle
import com.digitall.digital_sofia.models.common.BannerMessage
import com.digitall.digital_sofia.models.common.StringSource

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

class BannerMessageWindowManager(private val context: Context) {

    companion object {
        private const val TAG = "BannerMessageWindowManagerTag"
        const val NOTIFICATION_VISIBLE_TIME = 3000L
    }

    private val binding = LayoutBannerViewBinding.inflate(LayoutInflater.from(context))

    private val currentWindow: PopupWindow

    private var timer: CountDownTimer? = null

    init {
        val width = Resources.getSystem().displayMetrics.widthPixels
        val height = WindowManager.LayoutParams.WRAP_CONTENT
        currentWindow = PopupWindow(binding.root, width, height)
        currentWindow.animationStyle = R.style.BannerMessageStyle
        currentWindow.isClippingEnabled = false
        binding.root.onClickThrottle {
            hideWindow()
        }
        fixInsets()
    }

    /**
     * On some android API padding to root view isn't applies with fitsSystemWindows.
     * So we have to apply padding manually in case. And it should be done on post, on next frame.
     * Because for some reason first frame is ignored.
     */
    private fun fixInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val topInsets =
                insets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars()).top
            OneShotPreDrawListener.add(view, false) {
                view.setPadding(0, topInsets, 0, 0)
            }
            WindowInsetsCompat.CONSUMED
        }
        ViewCompat.requestApplyInsets(binding.root)
    }

    fun showMessage(message: BannerMessage, anchorView: View) {
        try {
            setupMessage(message)
            showWindow(anchorView)
        } catch (e: Exception) {
            logError("showMessage Exception: ${e.message}", e, TAG)
            // WindowManager$BadTokenException catch
            // Maybe show a dialog here instead as fallback
            Toast.makeText(context, message.message.getString(context), Toast.LENGTH_LONG).show()
        }
    }

    private fun setupMessage(message: BannerMessage) {
        binding.tvBannerText.text = when (message.message) {
            is StringSource.Res -> binding.tvBannerText.context.getString(message.message.resId)
            is StringSource.Text -> message.message.text
        }
        binding.ivBannerIcon.isVisible = message.icon != null
        message.icon?.let {
            binding.ivBannerIcon.setImageResource(it)
        }
        binding.tvBannerText.textAlignment = when (message.gravity) {
            BannerMessage.Gravity.CENTER -> View.TEXT_ALIGNMENT_CENTER
            BannerMessage.Gravity.START -> View.TEXT_ALIGNMENT_TEXT_START
        }
        val bgColor = when (message.state) {
            BannerMessage.State.SUCCESS -> R.color.color_success
            BannerMessage.State.ERROR -> R.color.color_orange
        }
        binding.rootLayout.backgroundColor(bgColor)
        binding.ivBannerIcon.backgroundColor(bgColor)
        binding.tvBannerText.backgroundColor(bgColor)
    }

    private fun showWindow(anchorView: View) {
        if (timer != null) {
            hideWindow()
        }

        currentWindow.showAtLocation(anchorView, Gravity.TOP, 0, 0)
        startExpireTimer()
    }

    fun hideWindow() {
        currentWindow.dismiss()
        dismissTimer()
    }

    private fun startExpireTimer() {
        timer = object : CountDownTimer(NOTIFICATION_VISIBLE_TIME, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // no impl
            }

            override fun onFinish() {
                hideWindow()
            }
        }
        timer?.start()
    }

    private fun dismissTimer() {
        timer?.cancel()
        timer = null
    }

}