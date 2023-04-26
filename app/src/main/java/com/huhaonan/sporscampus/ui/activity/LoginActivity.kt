package com.huhaonan.sporscampus.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.huhaonan.sporscampus.logic.model.UserViewModel
import com.huhaonan.sporscampus.ui.data.User
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity() {

    //声明成员变量
    lateinit var userViewModel: UserViewModel
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)


        //设置数据
//        binding.data = myViewModel

        //给data实现自我的监听
        binding.lifecycleOwner= this
      /*  myViewModel.usersLiveData.observe(this, Observer { user ->
//            Toast.makeText(this,"${user.isFailure}",Toast.LENGTH_SHORT).show()
        })*/

        //监听登录按钮
        binding.loginBtnLogin.setOnClickListener {

            var account = binding.loginEditAccount.text.trim().toString()
            var password = binding.passwordIdnputLayout.editText?.text.toString()

            val user = userViewModel.selectUserByUser(user = User(account, password))
            println(user)

            if(!validatePassword(password)){

                showMessage(password)
                binding.passwordIdnputLayout.isErrorEnabled =true
                binding.passwordIdnputLayout.error ="密码字数过少"

            }else{
                //            if (user != null) {
                val intent = Intent(this, MainActivity::class.java)
                //启动Activity，接受一个Intent参数
                startActivity(intent)
//            }
            }


        }

        //点击注册按钮
       binding.loginBtnRegister.setOnClickListener {
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
    }
    fun validatePassword(password:String):Boolean{
        return password.length >6
    }
}