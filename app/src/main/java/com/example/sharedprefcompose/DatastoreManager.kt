package com.example.sharedprefcompose

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DatastoreManager @Inject constructor(@ApplicationContext context:Context)  {
    private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = "TEMP_DATA")
    private val dataStore = context.dataStore
    companion object{
        val nameKey = stringPreferencesKey("NAME")
        val isDarkModeKey = booleanPreferencesKey("DARK_MODE_KEY")
        val passwordKey = stringPreferencesKey("PASSWORD")
        val userNameKey = stringPreferencesKey("USER_NAME")
        val mobileKey = stringPreferencesKey("MOBILE")
        val addressKey = stringPreferencesKey("ADDRESS")
        val pincodeKey = stringPreferencesKey("PIN_CODE")
        val companyKey = stringPreferencesKey("COMPANY")
    }
    suspend fun setUser(user:User){
        dataStore.edit {
            it[nameKey] = user.name!!
            it[userNameKey] = user.userName!!
            it[passwordKey]=user.password!!
            it[mobileKey]=user.phoneNumber!!
            it[addressKey]=user.address!!
            it[companyKey] = user.companyName!!
            it[pincodeKey] = user.pinCode!!
        }
    }
     fun getUser():Flow<User>{
        return dataStore.data.catch { exception->
        if (exception is IOException){
            emit(emptyPreferences())
        }
        else{
            throw exception
        }
        }.map { preference->
            val name = preference[nameKey]?: "suraj"
            val company = preference[companyKey]?: "suraj"
            val pin = preference[pincodeKey]?: "suraj"
            val address = preference[addressKey]?: "suraj"
            val mobile = preference[mobileKey]?: "suraj"
            val password = preference[passwordKey]?: "suraj"
            val userName = preference[userNameKey]?: "suraj"

            User(name,userName,password,company,mobile,address,pin)
        }
    }
    suspend fun setTheme(isDarkMode:Boolean){
        dataStore.edit {
            it[isDarkModeKey] = isDarkMode
        }
    }

    fun getTheme(): Flow<Boolean> {
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
            }
            .map { preferences ->
            val isDark = preferences[isDarkModeKey] ?:  false
            isDark


        }
    }
     suspend fun setName (name: String) {
        dataStore.edit {
            it[nameKey] = name
        }
    }
    suspend fun setUserName (username: String) {
        dataStore.edit {
            it[userNameKey] = username
        }
    }
    suspend fun setPass (password: String) {
        dataStore.edit {
            it[passwordKey] = password
        }
    }
    suspend fun setMobile (mobile: String) {
        dataStore.edit {
            it[mobileKey] = mobile
        }
    }
    suspend fun setAddress (address: String) {
        dataStore.edit {
            it[addressKey] = address
        }
    }
    suspend fun setPin (pincode: String) {
        dataStore.edit {
            it[pincodeKey] = pincode
        }
    }
    suspend fun setCompany (company: String) {
        dataStore.edit {
            it[companyKey] = company
        }
    }

    suspend fun getName():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[nameKey]?: "suraj"
            name
        }

    }
    suspend fun getUserName():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[userNameKey]?: "suraj"
            name
        }

    }
    suspend fun getPassword():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[passwordKey]?: "suraj"
            name
        }

    }
    suspend fun getMobile():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[mobileKey]?: "suraj"
            name
        }

    }
    suspend fun getAddress():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[addressKey]?: "suraj"
            name
        }

    }
    suspend fun getPinCode():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[pincodeKey]?: "suraj"
            name
        }

    }
    suspend fun getCompany():Flow<String>{
        return dataStore.data.catch {exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }.map{ preferences ->
            val name = preferences[companyKey]?: "suraj"
            name
        }

    }

}

