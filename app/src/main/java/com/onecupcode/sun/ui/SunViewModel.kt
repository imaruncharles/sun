package com.onecupcode.sun.ui

import androidx.lifecycle.ViewModel
import com.onecupcode.sun.api.SunApi

class SunViewModel() : ViewModel() {


    suspend  fun get(){
       val values = SunApi.retrofitServices.getGetdetails()

        println(values.data.toString())
    }

}