package com.example.jetpackcomponents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var colorViewModel: ViewModel
    lateinit var mainActivityRootView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        mainActivityRootView.setBackgroundColor(colorViewModel.getColorResource())

        colorButton.setOnClickListener {
            val color = generateRandomColor()
            mainActivityRootView.setBackgroundColor(color)
            colorViewModel.setColorResource(color)
        }
    }

    private fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}