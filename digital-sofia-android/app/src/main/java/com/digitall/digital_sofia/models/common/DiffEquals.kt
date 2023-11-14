package com.digitall.digital_sofia.models.common

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

interface DiffEquals {

    fun isItemSame(other: Any?): Boolean

    fun isContentSame(other: Any?): Boolean

}