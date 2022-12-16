package com.example.myapplication.ui.cars

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.text.Layout

class CarsViewModel : ViewModel() {

    private val _ly = MutableLiveData<Layout>().apply {

    }
    val ly : LiveData<Layout> = _ly
    private val _text1 = MutableLiveData<String>().apply {
        value = "Sedan"
    }
    val text1: LiveData<String> = _text1


    private val _text2 = MutableLiveData<String>().apply {
        value = "SUV"
    }
    val text2: LiveData<String> = _text2


    private val _text3 = MutableLiveData<String>().apply {
        value = "Pick Up"
    }
    val text3: LiveData<String> = _text3


    private val _text4 = MutableLiveData<String>().apply {
        value = "Hatch Back "
    }
    val text4: LiveData<String> = _text4

    private val _text5 = MutableLiveData<String>().apply {
        value = "Otros"
    }
    val text5: LiveData<String> = _text5

}