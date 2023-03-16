package com.huhaonan.sporscampus.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SportsCampusApplication :Application(){
    //静态变量context,启动应用程序时候会自动实例化这个类
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate(){
        super.onCreate()
        context = applicationContext
    }
}