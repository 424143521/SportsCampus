package com.huhaonan.sporscampus.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.huhaonan.sporscampus.ui.MainActivity
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityLoginBinding
import com.huhaonan.sporscampus.ui.RegistActivity
import com.huhaonan.sporscampus.ui.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
//        val users = mainViewModel.getUsers()
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        //设置数据
//        binding.data = myViewModel
        //给data实现自我的监听
        binding.lifecycleOwner= this
        /*   loginViewModel.getUsers().observe(this, Observer { user ->

           })*/
        binding.loginBtnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //启动Activity，接受一个Intent参数
            startActivity(intent)
        }

        binding.loginBtnRegister.setOnClickListener {
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
    }
}