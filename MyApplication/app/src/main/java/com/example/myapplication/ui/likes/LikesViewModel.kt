package com.example.myapplication.ui.likes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class LikesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is likes Fragment"
    }
    val text: LiveData<String> = _text
}