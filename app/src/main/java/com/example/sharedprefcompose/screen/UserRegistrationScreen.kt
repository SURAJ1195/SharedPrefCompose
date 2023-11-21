package com.example.sharedprefcompose.screen

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sharedprefcompose.User
import com.example.sharedprefcompose.component.Button
import com.example.sharedprefcompose.component.InputField
import com.example.sharedprefcompose.navigation.NavigationScreens
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavHostController,model:SettingsViewModel = hiltViewModel()) {
    BackHandler(enabled = true) {
       navController.popBackStack()
       navController.navigate(NavigationScreens.MainScreen.name)
    }

    val name = remember{ mutableStateOf("") }
    val phoneNumber = remember{ mutableStateOf("") }
    val companyName = remember{ mutableStateOf("") }
    val address = remember{ mutableStateOf("") }
    val pinCode = remember{ mutableStateOf("") }
    val userName = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }


    val context = LocalContext.current
    val user =Gson().fromJson(model.dataa.getString("USER_DATA",null),User::class.java)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = if (model.isNight.value) Color.DarkGray else Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(value = name, label = "Name")
            InputField(value = phoneNumber, label = "Mobile Number")
            InputField(value = companyName, label = "Company Name")
            InputField(value = address, label = "Address")
            InputField(value = pinCode, label = "PinCode")
            InputField(value = userName, label = "User Name")
            InputField(value = password, label = "Password")
            Button {
                if(name.value ==""){
                    Toast.makeText(context,"Name should not be empty",Toast.LENGTH_SHORT).show()
                }else if(phoneNumber.value ==""){
                    Toast.makeText(context,"Phone number should not be empty",Toast.LENGTH_SHORT).show()

                }
                else if(companyName.value==""){
                    Toast.makeText(context,"Company name should not be empty ",Toast.LENGTH_SHORT).show()
                }
                else if(address.value==""){
                    Toast.makeText(context,"address should not be empty ",Toast.LENGTH_SHORT).show()
                }else if(companyName.value==""){
                   Toast.makeText(context,"Company name should not be empty ", Toast.LENGTH_SHORT).show()
                }
                else if(pinCode.value==""){
                    Toast.makeText(context,"PinCode should not be empty ", Toast.LENGTH_SHORT).show()
                }else if(userName.value==""){
                    Toast.makeText(context,"User Name should not be empty ", Toast.LENGTH_SHORT).show()
                }else if(password.value==""){
                    Toast.makeText(context,"password should not be empty ", Toast.LENGTH_SHORT).show()
                }
//                else if(model.datastoreManager1.get.userName == userName.value.trim()){
//                    Toast.makeText(context,"User name present now so try with other one", Toast.LENGTH_SHORT).show()
//                }
                else {
                    val user = User(
                        name = name.value.trim(),
                        userName = userName.value.trim(),
                        password = password.value.trim(),
                        address = address.value.trim(),
                        pinCode = pinCode.value.trim(),
                        phoneNumber = phoneNumber.value.trim(),
                        companyName = companyName.value.trim()
                    )
//                    val gson = Gson()
//                    val gsonData = gson.toJson(user,User::class.java)
//                    val data = model.dataa.edit()

                  model.setDetails(user)
                    Toast.makeText(context,"User Data Saved Successfully", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                    navController.navigate(NavigationScreens.MainScreen.name)
                }
            }
        }
    }

}