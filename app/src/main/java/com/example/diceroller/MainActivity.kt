package com.example.diceroller

// Import necessary libraries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme


// Main activity for the Dice Roller app.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply the DiceRollerTheme to the entire app UI
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the DiceRollerApp composable to build the app UI
                    DiceRollerApp()
                }
            }
        }
    }
}


// A composable function that displays the Dice Roller app UI.
// This is the root composable for the preview.

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

// Pre-define dice image resources for clarity and design mode compatibility
val diceImage1 = R.drawable.dice_1
val diceImage2 = R.drawable.dice_2
val diceImage3 = R.drawable.dice_3
val diceImage4 = R.drawable.dice_4
val diceImage5 = R.drawable.dice_5
val diceImage6 = R.drawable.dice_6


// A composable function that displays a dice image and a button to roll the dice.

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Use mutableStateOf to store the current dice roll result
    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> diceImage1
        2 -> diceImage2
        3 -> diceImage3
        4 -> diceImage4
        5 -> diceImage5
        else -> diceImage6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        // Display the dice image based on the current roll result
        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        Button(
            onClick = { result = (1..6).random() }, // Update result on button click
        ) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}