package com.digitall.digital_sofia.data.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/

class BigDecimalToStringConverter {

    @TypeConverter
    fun toString(data: BigDecimal?): String? {
        if (data == null) return null
        return data.toPlainString()
    }

    @TypeConverter
    fun fromString(data: String?): BigDecimal? {
        if (data == null) return null
        return BigDecimal(data)
    }

}