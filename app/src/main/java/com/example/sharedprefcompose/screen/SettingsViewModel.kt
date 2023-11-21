package com.example.sharedprefcompose.screen

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharedprefcompose.DatastoreManager
import com.example.sharedprefcompose.User
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private  val sharedPreferences: SharedPreferences,private val datastoreManager: DatastoreManager):ViewModel() {
    val user = mutableStateOf<User?>(null)
    val isNight = mutableStateOf(false)

     init {
        val x =  datastoreManager.getUser()
             viewModelScope.launch {
                 val job1 = launch {
                     x.collect{
                         user.value=it
                     }
                 }
                 val job2 = launch {
                     datastoreManager.getTheme().collect{
                         isNight.value = it
                     }
                 }



//
             }




     }
    fun getUser(): Flow<User> {
        return datastoreManager.getUser()
    }


    fun setDetails(user: User){
        viewModelScope.launch {


            datastoreManager.apply {
                async { setUser(user) }


            }

        }
    }


     fun onClickNightMode(){
         viewModelScope.launch {

             isNight.value = ! isNight.value
             datastoreManager.setTheme(isNight.value)
         }

    }
}

