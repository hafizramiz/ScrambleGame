package com.example.scramblegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scramblegame.ui.GameScreen
import com.example.scramblegame.ui.MainViewModel
import com.example.scramblegame.ui.theme.ScrambleGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("On create calisti")
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ScrambleGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
//                    CounterScreen(
//                        mainViewModel = mainViewModel,
//                        functionForUserInput = { mainViewModel.printUserInput(it) },
//                        a = mainViewModel.userGuess
//                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterScreen(mainViewModel: MainViewModel, functionForUserInput: (String) -> Unit, a: String) {
    // UI that reacts to state changes
    var deneme = remember {
        mutableStateOf("bos")
    }

    Column {
        Text(text = "Counter: ${mainViewModel.counterState.value}")
        TextField(value = a, onValueChange = {
            //mainViewModel.userInputState.value= it
            //println("ekran tarafinda kull girdisi: ${mainViewModel.userInputState.value}")
            functionForUserInput
        })

        Button(onClick = { mainViewModel.incrementCounter() }) {
            Text("Increment")
        }
    }
}


