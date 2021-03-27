package com.example.jetpackcomponents

import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    private var colorResource: Int = 0xfff

    fun setColorResource(colorResource: Int){
        this.colorResource = colorResource
    }

    fun getColorResource() = colorResource
}