package com.example.biggernumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import biggernumbergame.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        assignNumbersToButtons()

        val btnRight: Button = binding.btnRight
        val btnLeft: Button = binding.btnLeft
        btnLeft.setOnClickListener {
            // Code here will run every time the left button is clicked
            // 1. Compare the numbers in the boxes
            checkAnswer(true)

            // 2. Pick new random number
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            // Code here will run every time the left button is clicked
            // Compare the numbers in the boxes
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }
    private fun checkAnswer (isLeftButtonSelected: Boolean) {
        val backgroundView: ConstraintLayout = binding.backgroundView
        val btnRight: Button = binding.btnRight
        val btnLeft: Button = binding.btnLeft
        val leftNum: Int = btnLeft.text.toString().toInt()
        val rightNum: Int = btnRight.text.toString().toInt()
        val isAnswerCorrect: Boolean = if (isLeftButtonSelected) {
            leftNum > rightNum
        } else {
            rightNum > leftNum
        }
        if (isAnswerCorrect) {
            // Correct answer!!
            // Change the background color
            backgroundView.setBackgroundColor(Color.GREEN)
            // Show a toast
            Toast.makeText( this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer!
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = 1..99
        val leftNum: Int = r.random()
        var rightNum: Int = r.random()
        while (rightNum == leftNum) {
            rightNum = r.random()
        }

        // Update the text on the buttons
        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }
    //TODO("Increase the contrast ratio of the red and green background to TV3 & TV4 ")

}
