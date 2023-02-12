package com.example.materialcomponent

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.materialcomponent.ui.theme.MaterialComponentTheme
import com.example.materialcomponent.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialComponentTheme {
                MaterialComponent()

            }
        }
    }
}

@Composable
fun MaterialComponent() {
    val textStateOne = remember { mutableStateOf(TextFieldValue()) }
    val textStateTwo = remember { mutableStateOf(TextFieldValue()) }
    val textStateThree = remember { mutableStateOf(TextFieldValue()) }
    val checkedState = remember { mutableStateOf(false) }
    val radioButtonState = remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()
    val passwordVisibility = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val toggleChecked = remember { mutableStateOf(false) }
    val switchState = remember { mutableStateOf(false) }
    val sliderPosition = remember { mutableStateOf(0.5f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Text View
        Text(
            text = "JetPack Compose Material",
            color = Purple500,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        //textField
        TextField(
            value = textStateOne.value,
            onValueChange = { textStateOne.value = it },
            label = { Text(text = "Enter Name", color = Color.Black) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black, textColor = Color.Black
            )
        )
        // OutlinedTextField
        OutlinedTextField(
            value = textStateTwo.value,
            onValueChange = { textStateTwo.value = it },
            label = { Text(text = "password", color = Color.Black)},
            trailingIcon = {
                IconButton(onClick = { passwordVisibility.value=!passwordVisibility.value}) {
                    Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                        contentDescription ="red eye",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Gray
                    ) }
            }, modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black, textColor = Color.Black
            )
        )


        OutlinedTextField(value = textStateThree.value,
            onValueChange ={textStateThree.value=it},
            label ={ Text(text = "comment", color = Color.Black)},
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.White), maxLines = 5
            , keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ), colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black, textColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.padding(5.dp))

        //Button
        Button(onClick = { Toast.makeText(context, "clicked Button", Toast.LENGTH_LONG).show() },
            shape = RoundedCornerShape(10.dp), elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp), modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text =  "Submit", modifier = Modifier.padding(6.dp))


        }
        Spacer(modifier = Modifier.padding(5.dp))


        OutlinedButton(onClick = { Toast.makeText(context,"",Toast.LENGTH_LONG).show() },
            shape = CircleShape, 
            elevation = ButtonDefaults.elevation(8.dp),
            modifier = Modifier.fillMaxWidth(0.5f)) {
            Text(text = "Submit", modifier = Modifier.padding(6.dp))
        }
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedButton(onClick = { Toast.makeText(context,"My Favourite",Toast.LENGTH_LONG).show()},
            shape = CircleShape, 
            elevation = ButtonDefaults.elevation(
                defaultElevation =6.dp,
                pressedElevation =8.dp,
                disabledElevation =0.dp
            ), modifier = Modifier.fillMaxWidth(0.6f)) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription ="", modifier = Modifier.padding(end = 8.dp) )
            Text(text = "My Favourite", modifier = Modifier.padding(6.dp))
        }


        //CheckBox
        Row(modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(30.dp, 0.dp, 30.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
            Checkbox(checked = checkedState.value ,
                onCheckedChange = { check-> checkedState.value=check },
            colors = CheckboxDefaults.colors(Purple500) )
            Text(text = "My checkBox", color = Purple500, fontSize = 15.sp)
        }
        //RadioButton
        Row(
            modifier = Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RadioButton(selected =  radioButtonState.value,
                onClick = { radioButtonState.value= true},
                colors = RadioButtonDefaults.colors(Purple500))
           Text(text = "First",
               color = Purple500,
               fontSize = 15.sp)
            RadioButton(selected = !radioButtonState.value,
                onClick = { radioButtonState.value=false },
                colors = RadioButtonDefaults.colors(Purple500))
            Text(text = "Second",
                color = Purple500,
                fontSize = 15.sp)

        }
        //IconToggleButton
        IconToggleButton(checked = toggleChecked.value,
            onCheckedChange ={toggleChecked.value=it} ) {
            val tint= animateColorAsState(
                if(toggleChecked.value){
                    Color(0xFFEC407A)
                }else{
                    Color(0xFFB0BEC5)
                }
            )
            Icon(imageVector =Icons.Filled.Favorite ,
                contentDescription ="Toggle Button", tint = tint.value)

        }

        //Switch
        Switch(checked =switchState.value ,
            onCheckedChange ={switchState.value=it},
            colors = SwitchDefaults.colors(Purple500) )
        //LinearProgressIndicator
        LinearProgressIndicator(progress = 0.5f)
        //CircularProgressIndicator
        CircularProgressIndicator(progress = 0.75f)
        //slider
        Slider(value = sliderPosition.value,
            onValueChange = {sliderPosition.value=it},
            modifier = Modifier.fillMaxWidth(0.8f))






    }
}

