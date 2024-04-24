/**
 * Please follow code style when editing project
 * Please follow principles of clean architecture
 * Created 2023 by Roman Kryvolapov
 **/
package com.digital.sofia.domain.repository.network.documents

import com.digital.sofia.domain.models.base.ResultEmittedData
import com.digital.sofia.domain.models.common.DownloadProgress
import com.digital.sofia.domain.models.documents.DocumentAuthenticationRequestModel
import com.digital.sofia.domain.models.documents.DocumentModel
import com.digital.sofia.domain.models.documents.DocumentsWithPaginationModel
import kotlinx.coroutines.flow.Flow
import java.io.File

interface DocumentsNetworkRepository {

    fun getDocuments(
        cursor: String? = null,
        status: String? = null,
    ): Flow<ResultEmittedData<DocumentsWithPaginationModel>>

    fun downloadFile(
        file: File,
        documentUrl: String,
    ): Flow<ResultEmittedData<DownloadProgress>>

    fun sendOpenedDocument(
        evrotrustTransactionId: String,
    ): Flow<ResultEmittedData<Unit>>

    fun requestIdentity(
        personalIdentificationNumber: String,
    ): Flow<ResultEmittedData<DocumentModel>>

    fun authenticateDocument(
        data: DocumentAuthenticationRequestModel,
        evrotrustTransactionId: String,
    ): Flow<ResultEmittedData<Unit>>

}