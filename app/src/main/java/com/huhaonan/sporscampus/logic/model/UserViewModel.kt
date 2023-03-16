package com.huhaonan.sporscampus.logic.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.huhaonan.sporscampus.ui.data.User
import com.huhaonan.sporscampus.util.Repository
import android.accounts.Account
import androidx.lifecycle.MutableLiveData


//viewModel只和界面数据有关
class UserViewModel(application: Application) : AndroidViewModel(application) {

    var repository: Repository
    var allUserLive: LiveData<List<User>>
    var userLive: LiveData<User>? = null


   /* fun getuserLive(user:User): LiveData<User>? {
        if (userLive == null) {
            userLive = MutableLiveData<User>(user)

        }
        return userLive
    }*/


    init {

        repository = Repository(application)
        //因为返回的是LiveData类型所以会自动在主线程中操作
        allUserLive = repository.allUserLive

    }


    fun selectUserByUser(user: User):LiveData<User> {
         userLive =  repository.getUser(user)
        return userLive as LiveData<User>

    }

    fun insertUser(user: User) {
        repository.insertUser(user)
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