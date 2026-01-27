package com.unusualapps.novotnysamuel.didilockit.datastore

import android.content.Context
import androidx.constraintlayout.core.dsl.Keys
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreRepositoryImpl(private val context: Context) : IDataStoreRepository {

    private val isLockedKey = booleanPreferencesKey(DataStoreConstants.IS_LOCKED)

    override val isLocked: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[isLockedKey] ?: false
        }

    override suspend fun toggleLock() {
        context.dataStore.edit { preferences ->
            val currentStatus = preferences[isLockedKey] ?: false
            preferences[isLockedKey] = !currentStatus
        }
    }
}