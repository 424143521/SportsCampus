package com.huhaonan.sporscampus

import android.content.Intent
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.huhaonan.sporscampus.ui.LoginActivity
import com.huhaonan.sportscampus.R
import java.util.*


//程序加载页
class Splash : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //延时操作
        val timer = Timer()
        timer.schedule(timetast, 0)
    }

    var timetast: TimerTask = object : TimerTask() {
        override fun run() {
            startActivity(Intent(this@Splash, LoginActivity::class.java)) //跳转登录界面
        }
    }
}