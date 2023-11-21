package com.example.sharedprefcompose.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sharedprefcompose.User
import com.example.sharedprefcompose.navigation.NavigationScreens
import com.google.gson.Gson

@Composable
fun SecondScreen(navController: NavHostController,viewModel:SettingsViewModel = hiltViewModel()) {
    BackHandler(enabled = true) {
        navController.popBackStack()
        navController.navigate(NavigationScreens.MainScreen.name)

    }
Surface(
    modifier = Modifier.fillMaxSize(),
    color = if(viewModel.isNight.value) Color.DarkGray else Color.White
) {
    val user by viewModel.getUser().collectAsState(initial = null)

  //  val user = Gson().fromJson(viewModel.dataa.getString("USER_DATA",null), User::class.java)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(user!=null){
            Text(text = user?.name!!, color =if(viewModel.isNight.value) Color.White else Color.Black, style = TextStyle(fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Default) )
            Text(text =user?.phoneNumber!! , color =if(viewModel.isNight.value) Color.White else Color.Black, style = TextStyle(fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Default) )
            Text(text =user?.address!! , color =if(viewModel.isNight.value) Color.White else Color.Black, style = TextStyle(fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Default) )
            Text(text = user?.companyName!!, color =if(viewModel.isNight.value) Color.White else Color.Black, style = TextStyle(fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Default) )
            Text(text =user?.pinCode!! , color =if(viewModel.isNight.value) Color.White else Color.Black, style = TextStyle(fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Default) )
        }



    }
}
}