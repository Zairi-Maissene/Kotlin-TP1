package com.example.tp1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.view.Gravity
import android.view.ViewGroup


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button)
        val email = findViewById<EditText>(R.id.input)
        val password = findViewById<EditText>(R.id.password_input)

        val defaultBackgroundColor = myButton.background // Store the default background drawable

        myButton.setOnClickListener { view ->
            // Change the background color when the Button gains focus
            myButton.background = getDrawable(R.color.purple_200);
            // Set your focused color here
            //get the Edittext value
            val emailText = email.getText().toString();
            val passwordText = password.getText().toString();
            val toastMsg = "Email: $emailText\nPassword: $passwordText"

            //Display toast:
            Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show() ;


        }
    }
}
