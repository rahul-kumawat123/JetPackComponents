package com.example.jetpackcomponents

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponents.viewmodels.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var colorViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        r_view?.setBackgroundColor(colorViewModel.getColorResource())

        colorButton.setOnClickListener {
            val color = generateRandomColor()
            r_view?.setBackgroundColor(color)
            colorViewModel.setColorResource(color)
        }

        liveDataDemoBtn.setOnClickListener {
            startActivity(Intent(this,LiveDataActivity::class.java))
        }
    }

    private fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}