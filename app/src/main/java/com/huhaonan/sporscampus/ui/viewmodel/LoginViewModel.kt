package com.huhaonan.sporscampus.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huhaonan.sporscampus.ui.data.User

class LoginViewModel: ViewModel() {
    val usersLiveData = MutableLiveData<List<User>>()
}