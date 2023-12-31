package com.example.sharedprefcompose

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModelProvider
import com.example.sharedprefcompose.navigation.MainNavigation
import com.example.sharedprefcompose.screen.SettingsViewModel
import com.example.sharedprefcompose.ui.theme.SharedPrefComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.prefs.Preferences

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPrefComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    MainNavigation()
                }
            }
        }
    }
}



