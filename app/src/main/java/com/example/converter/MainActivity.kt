 package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.converter.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

 class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            convertMoney()
        }

        
    }

     private fun convertMoney() {
         val inputText = binding.inputField.text.toString().toDouble()
         var calc = inputText /1000000000 *52.12


         var roundUp = binding.convertSwitch.isChecked
         if (roundUp){
             calc = ceil(calc)
         }
         var formattedResult = NumberFormat.getCurrencyInstance().format(calc)
         binding.displayField.text = getString(R.string.display,formattedResult)

     }
 }