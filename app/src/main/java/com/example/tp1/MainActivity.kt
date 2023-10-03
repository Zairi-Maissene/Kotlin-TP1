package com.example.tp1

import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp1.ui.theme.TP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button)
        val myInput = findViewById<EditText>(R.id.input)

        val defaultBackgroundColor = myButton.background // Store the default background drawable

        myButton.setOnClickListener { view ->
                // Change the background color when the Button gains focus
                myButton.background = getDrawable(R.color.purple_200);
                     // Set your focused color here
        }
        myInput.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // Change the background color when the Button gains focus
                myInput.background = getDrawable(R.color.purple_200);
            } else {
                // Restore the default background color when focus is lost
                myInput.background = defaultBackgroundColor
            }
        }
        }
}
