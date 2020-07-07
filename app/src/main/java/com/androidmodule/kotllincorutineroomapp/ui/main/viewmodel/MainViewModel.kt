package com.androidmodule.kotllincorutineroomapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidmodule.kotllincorutineroomapp.data.api.ApiHelper
import com.androidmodule.kotllincorutineroomapp.data.local.DbHelper
import com.androidmodule.kotllincorutineroomapp.data.local.entity.User
import com.androidmodule.kotllincorutineroomapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val apiHelper: ApiHelper, private val dbHelper: DbHelper) :
    ViewModel() {

    private var users = MutableLiveData<Resource<List<User>>>()

    init {
        fetchUser();
    }

    private fun fetchUser() {
        viewModelScope.launch(Dispatchers.Main) {
            users.value = Resource.loading(null)
            try {
                val usersValue  = async(Dispatchers.IO) { doTask()}
                val usersData = usersValue.await()
                Log.d("",""+usersData.forEachIndexed{idx,base ->
                    Log.i("data1","item1$idx:\n$base")})
                users.value = Resource.success(usersData)
            } catch (e: Exception) {
                e.printStackTrace()
                users.value  = Resource.error(e.toString(), null)
            }
        }
    }

    private suspend fun doTask():List<User> {
        var usersToInsertInDB = mutableListOf<User>()
        if (dbHelper.getUsers().isEmpty()) {
            val usersValue = apiHelper.getUsers()

            for (apiUser in usersValue) {
                val user = User(
                    apiUser.id,
                    apiUser.name,
                    apiUser.email,
                    apiUser.avatar
                )
                usersToInsertInDB.add(user)
            }
            Log.d("isEmpty", "isEmpty")
            dbHelper.insertAll(usersToInsertInDB)
        }
        else {
            val usersData = dbHelper.getUsers()
            usersToInsertInDB.addAll(usersData)
        }
        Log.d("",""+usersToInsertInDB.forEachIndexed{idx,base ->
            Log.i("data2","item2$idx:\n$base")})
        return usersToInsertInDB;
    }


    fun getUsers(): MutableLiveData<Resource<List<User>>> {
        return users;
    }
}