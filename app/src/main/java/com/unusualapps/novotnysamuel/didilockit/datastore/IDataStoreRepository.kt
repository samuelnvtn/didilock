package com.unusualapps.novotnysamuel.didilockit.datastore

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {

    val isLocked: Flow<Boolean>
    suspend fun toggleLock()
}