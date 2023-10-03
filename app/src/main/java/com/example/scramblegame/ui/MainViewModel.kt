package com.example.scramblegame.ui
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
/// Burasi Ders Icerigi Niteligindedir.
class MainViewModel:ViewModel() {
    // Ui state'i burda mutable icinde tuttum
    var counterState: MutableState<Int> = mutableStateOf(0)
    // Kullanici girdisi icin ayri bir state tanimladim.
    var userInputState: MutableState<String> = mutableStateOf("a")
    var userGuess by mutableStateOf("")
        private set
    // Tiklayinca artiracak fonksiyonu da burda yazdim
    // Burasi Value Notifier'in aynisi gibi calisiyor.
    // Value Notifier Ornegi:
    //ValueNotifier<int> counter = ValueNotifier<int>(0);
    // artirmak icin de:   counter.value++;
    /// Burda da state'im Int degilde bir model olacak.
    //private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState())
    // val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    // Burda da artik Paylasabilir hale getiriyorum.
    fun incrementCounter() {
        counterState.value=10
    }

    fun printUserInput(userInput: String ){
        userInputState.value=userInput
        println("Kullanici girdisi: ${userInputState.value}")
        println("Kullanici girdisi: ${userInputState}")

    }
}
