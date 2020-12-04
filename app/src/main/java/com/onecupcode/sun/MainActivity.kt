package com.onecupcode.sun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.onecupcode.sun.api.SunApi
import com.onecupcode.sun.ui.SunViewModel
import com.onecupcode.sun.ui.ViewModelFactory
import kotlinx.coroutines.*
import kotlin.coroutines.Continuation

class MainActivity : AppCompatActivity() {


    private val job = Job()

    private val scopeIO = CoroutineScope(job + Dispatchers.IO)

    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel : SunViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = ViewModelFactory()
        viewModel= ViewModelProvider(this,viewModelFactory)
            .get(SunViewModel::class.java)



        scopeIO.launch {
            viewModel.get()
        }



    }
}