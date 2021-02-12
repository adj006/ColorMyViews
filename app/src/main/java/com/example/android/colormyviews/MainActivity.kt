package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.android.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
                listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                        binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                        binding.redButton, binding.yellowButton, binding.greenButton)

        for (item in clickableViews) {
             item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view) {
            // Boxes using Color class colors for background
            binding.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText -> view.setBackgroundColor(Color.GRAY)
            // Boxes using Android color resources for background
            binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)
            // Boxes using custom colors for background
            binding.redButton -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            binding.yellowButton -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            binding.greenButton -> binding.boxFiveText.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}