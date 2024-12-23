/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
sealed class ErrorState : Parcelable, Serializable {

    object Ready : ErrorState()

    data class Error(
        val iconRes: Int?,
        val showIcon: Boolean?,
        val showTitle: Boolean?,
        val title: StringSource?,
        val showDescription: Boolean?,
        val description: StringSource?,
        val showActionOneButton: Boolean?,
        val showActionTwoButton: Boolean?,
        val actionOneButtonText: StringSource?,
        val actionTwoButtonText: StringSource?,
    ) : ErrorState()
}