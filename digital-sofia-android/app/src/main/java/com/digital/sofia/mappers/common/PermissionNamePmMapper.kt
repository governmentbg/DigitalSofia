/**
 * Map permission Android ID into a readable name for UI.
 * e.g. Manifest.permission.READ_CONTACTS -> "Contacts"
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 */
package com.digital.sofia.mappers.common

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_CONTACTS
import com.digital.sofia.R
import com.digital.sofia.data.mappers.base.BaseMapper
import com.digital.sofia.utils.CurrentContext

class PermissionNamePmMapper(
    private val currentContext: CurrentContext,
) : BaseMapper<String, String>() {

    override fun map(from: String): String {
        return currentContext.get().getString(
            when (from) {
                READ_CONTACTS -> R.string.permissions_contacts
                CAMERA -> R.string.permissions_camera
                ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION -> R.string.permissions_location
                else -> R.string.unknown
            }
        )
    }
}