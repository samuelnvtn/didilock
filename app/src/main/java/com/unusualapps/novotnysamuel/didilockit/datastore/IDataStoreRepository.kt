package com.unusualapps.novotnysamuel.didilockit.datastore

import com.unusualapps.novotnysamuel.didilockit.model.LockStatus
import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {

    val lockStatus: Flow<LockStatus>

    suspend fun toggleLock()
}