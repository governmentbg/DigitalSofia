/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.models.common

data class InputLockState(
    val state: LockState,
    var timeLeftMilliseconds: Long?,
)

enum class LockState {
    LOCKED,
    UNLOCKED,
}