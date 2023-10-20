package com.example.newapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.textfield.TextInputLayout
import android.telephony.SmsManager

class PizzaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)

        val prenom = findViewById<TextInputLayout>(R.id.prenomField)
        val address = findViewById<TextInputLayout>(R.id.adressField)
        val pizzaType: AutoCompleteTextView = findViewById(R.id.pizzaTypeElement)
        val listType= resources.getStringArray(R.array.pizzaSize)
        val errorMessage="Veuillez remplir les champs du formulaire!"


        val fromage = findViewById<CheckBox>(R.id.checkBox1)
        val harissa = findViewById<CheckBox>(R.id.checkBox2)
        val sauce = findViewById<CheckBox>(R.id.checkBox3)
        val champignon = findViewById<CheckBox>(R.id.checkBox4)
        val submitBtn = findViewById<Button>(R.id.submitCommande)
        val disabledBtn : Boolean

         var selectedValue =""

        val typeAdapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, listType)
        pizzaType.setAdapter(typeAdapter)

        pizzaType.setOnItemClickListener{adapterView,view,i,l ->
            selectedValue= adapterView.getItemAtPosition(i).toString()
        }


        submitBtn.setOnClickListener OnClickListener@{

            if (prenom.editText?.text.toString() === ""|| address.editText?.text.toString()===""|| selectedValue === "") {
                Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            var totalAmount: Int = 0
            val ingResult = StringBuilder()
            if (sauce.isChecked) {
                ingResult.append("Sauce ")
            }
            if (harissa.isChecked) {
                ingResult.append("Harissa ")
            }
            if (champignon.isChecked) {
                ingResult.append("champignon ")
            }
            if (fromage.isChecked) {
                ingResult.append("fromage")
            }

            val message = "The client "+prenom.editText?.text.toString()+" in the address "+address.editText?.text.toString()+" ordered a "+selectedValue+" pizza with the ingredients "+ ingResult.toString() ;
            val phoneNumber = "+21652325452"


            try {

                // on below line we are initializing sms manager.
                //as after android 10 the getDefault function no longer works
                //so we have to check that if our android version is greater
                //than or equal toandroid version 6.0 i.e SDK 23
                val smsManager:SmsManager
                if (Build.VERSION.SDK_INT>=23) {
                    //if SDK is greater that or equal to 23 then
                    //this is how we will initialize the SmsManager
                    smsManager = this.getSystemService(SmsManager::class.java)
                } else{
                    //if user's SDK is less than 23 then
                    //SmsManager will be initialized like this
                    smsManager = SmsManager.getDefault()
                }

                // on below line we are sending text message.
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)

                // on below line we are displaying a toast message for message send,
                Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()

            } catch (e: Exception) {

                // on catch block we are displaying toast message for error.
                Toast.makeText(applicationContext, e.message.toString(), Toast.LENGTH_LONG)
                    .show()
                print(e.message.toString())
            }
        }







    }
}