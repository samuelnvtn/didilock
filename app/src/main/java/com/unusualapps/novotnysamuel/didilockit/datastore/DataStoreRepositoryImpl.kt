package com.unusualapps.novotnysamuel.didilockit.datastore

import android.content.Context
import androidx.constraintlayout.core.dsl.Keys
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.unusualapps.novotnysamuel.didilockit.model.LockStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataStoreRepositoryImpl(private val context: Context) : IDataStoreRepository {

    private val isLockedKey = booleanPreferencesKey(DataStoreConstants.IS_LOCKED)
    val timeKey = stringPreferencesKey(DataStoreConstants.TIME)

    override val lockStatus: Flow<LockStatus> = context.dataStore.data
        .map { preferences ->
            LockStatus(
                isLocked = preferences[isLockedKey] ?: false,
                timeOfChange = preferences[stringPreferencesKey(DataStoreConstants.TIME)] ?: "Unknown"
            )
        }

    override suspend fun toggleLock() {
        context.dataStore.edit { preferences ->
            val currentStatus = preferences[isLockedKey] ?: false
            preferences[isLockedKey] = !currentStatus

            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
            val currentTime = LocalDateTime.now().format(formatter)
            preferences[timeKey] = currentTime
        }
    }
}