package com.androidmodule.kotllincorutineroomapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidmodule.kotllincorutineroomapp.data.api.ApiHelper
import com.androidmodule.kotllincorutineroomapp.data.local.DbHelper
import com.androidmodule.kotllincorutineroomapp.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper,private  val dbHelper: DbHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(apiHelper,dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}