package com.huhaonan.sporscampus.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.huhaonan.sporscampus.logic.dao.UserDao
import com.huhaonan.sporscampus.logic.model.UserViewModel
import com.huhaonan.sporscampus.logic.roomdatabase.AppDatabase
import com.huhaonan.sporscampus.ui.data.User

import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityRegisterBinding

class RegistActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel


    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_register
        )


        binding.register.setOnClickListener {
            Toast.makeText(this,"执行",Toast.LENGTH_LONG).show()
            var account = binding.userAccount.text.toString()
            var passWord =  binding.password.text.toString()
           userViewModel.insertUser(user = User(account,passWord))
            Toast.makeText(this,"注册完毕",Toast.LENGTH_LONG).show()
            finish()
        }

    }

    fun add(){
      }
    fun updateView(){

    }
}