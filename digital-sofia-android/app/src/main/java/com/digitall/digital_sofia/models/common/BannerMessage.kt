package com.digitall.digital_sofia.models.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.digitall.digital_sofia.R

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

data class BannerMessage(
    val message: StringSource,
    @DrawableRes val icon: Int? = R.drawable.ic_error,
    val state: State = State.ERROR,
    val gravity: Gravity = Gravity.START
) {

    enum class State {
        ERROR,
        SUCCESS
    }

    enum class Gravity {
        START,
        CENTER
    }

    companion object {
        /**
         * Red error banners with [message] and error [icon] and gravity start.
         */
        fun error(
            message: String,
            @DrawableRes icon: Int = R.drawable.ic_error
        ): BannerMessage {
            return BannerMessage(StringSource.Text(message), icon, State.ERROR)
        }

        fun error(
            @StringRes message: Int,
            @DrawableRes icon: Int = R.drawable.ic_error
        ): BannerMessage {
            return BannerMessage(StringSource.Res(message), icon, State.ERROR)
        }

        /**
         * Green success banners with [message] and success [icon] and gravity start.
         */
        fun success(
            message: String,
            @DrawableRes icon: Int = R.drawable.ic_success
        ): BannerMessage {
            return BannerMessage(StringSource.Text(message), icon, State.SUCCESS)
        }

        fun success(
            @StringRes message: Int,
            @DrawableRes icon: Int = R.drawable.ic_success
        ): BannerMessage {
            return BannerMessage(StringSource.Res(message), icon, State.SUCCESS)
        }

        /**
         * Green success banners with simple [message] in the center of the banner.
         */
        fun successCenter(message: String): BannerMessage {
            return BannerMessage(StringSource.Text(message), null, State.SUCCESS, Gravity.CENTER)
        }

        fun successCenter(@StringRes message: Int): BannerMessage {
            return BannerMessage(StringSource.Res(message), null, State.SUCCESS, Gravity.CENTER)
        }
    }
}