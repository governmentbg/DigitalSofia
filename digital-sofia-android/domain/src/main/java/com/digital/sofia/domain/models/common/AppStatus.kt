/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.domain.models.common

import com.digital.sofia.domain.models.base.TypeEnum

enum class AppStatus(override val type: String) : TypeEnum {
    NOT_REGISTERED("NOT_REGISTERED"),
    REGISTERED("REGISTERED"),
}