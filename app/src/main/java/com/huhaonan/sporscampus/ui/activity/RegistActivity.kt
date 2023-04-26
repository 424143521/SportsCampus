package com.huhaonan.sporscampus.ui.activity

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.huhaonan.sporscampus.logic.Repository
import com.huhaonan.sporscampus.logic.dao.UserDao
import com.huhaonan.sporscampus.logic.model.UserViewModel
import com.huhaonan.sporscampus.ui.data.User
import com.huhaonan.sporscampus.util.SportsCampusApplication

import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityRegisterBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegistActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel


    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_register
        )


        //注册一个用户
        binding.register.setOnClickListener {
            var account = binding.userAccount.text.toString()
            var passWord =  binding.password.text.toString()
            val user = User(account, passWord);
            GlobalScope.launch(Dispatchers.Main){

            val result = userViewModel.insertUser(user)
                if (result>0){
                    Toast.makeText(SportsCampusApplication.context,"注册成功",Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(SportsCampusApplication.context,"注册失败",Toast.LENGTH_LONG).show()
                }

            }
        }

    }

    fun add(){
      }
    fun updateView(){

    }
}