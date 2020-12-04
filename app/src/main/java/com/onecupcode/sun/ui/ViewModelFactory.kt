package com.onecupcode.sun.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onecupcode.sun.api.SunApi

class ViewModelFactory()  : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SunViewModel::class.java)){
           return SunViewModel() as T
        }

        throw IllegalArgumentException("")
    }
}