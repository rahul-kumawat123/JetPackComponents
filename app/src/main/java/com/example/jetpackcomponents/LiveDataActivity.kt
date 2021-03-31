package com.example.jetpackcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackcomponents.fragments.FragmentDisplayData

class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        // Add fragment to view at runtime
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,FragmentDisplayData())
        fragmentTransaction.commit()
    }
}