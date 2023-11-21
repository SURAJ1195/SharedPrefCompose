package com.example.sharedprefcompose.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    value: MutableState<String>,
    label: String
){
    OutlinedTextField(value = value.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        onValueChange = {
            value.value = it
        },
        label = { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray
        ), maxLines = 1,
        singleLine = true
    )
}
@Composable
fun Button(
    onclick: ()-> Unit
) {
    val context = LocalContext.current




    androidx.compose.material3.Button(
        onClick = {
            onclick.invoke()
        },
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(3.dp, Color.Blue),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,

        ),
        modifier = Modifier
            .padding(29.dp)
            .fillMaxWidth()

    ) {
        Text(
            text = "Save to DB",
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
    }
}
