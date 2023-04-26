package com.huhaonan.sporscampus.logic.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.huhaonan.sporscampus.ui.data.User
import com.huhaonan.sporscampus.logic.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread


//viewModel只和界面数据有关
class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository
    var allUserLive: LiveData<List<User>>
    var userLive: LiveData<User>? = null



    init {

        repository = Repository(application)
        //因为返回的是LiveData类型所以会自动在主线程中操作
        allUserLive = repository.allUserLive

    }


    fun selectUserByUser(user: User):LiveData<User> {
         userLive =  repository.getUser(user)
        return userLive as LiveData<User>

    }

     suspend fun insertUser(user: User):Long {
       /*viewModelScope.launch {

       }*/
         val job = viewModelScope.async(Dispatchers.IO) {

             val result = repository.insertUser(user)
             result

             /*  withContext(Dispatchers.Main){
                   adapter.notifyDataSetChanged()
               }*/
         }

         return job.await()


         /*   thread {
                repository.insertUser(user)
            }*/
    }

    fun updateUser(user: User) {
        repository.updateUser(user)
    }

    fun deleteUser(user: User) {
        repository.deleteUser(user)
    }

    fun deleteAllUsers() {
        repository.deleteAllUsers()
    }
}