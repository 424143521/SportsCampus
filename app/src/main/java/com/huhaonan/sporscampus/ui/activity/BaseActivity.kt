package com.huhaonan.sporscampus.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //JavaClass获取当前实例的class对象，然后使用simpleName获取当前实例的类名
        Log.i("BaseActivity",javaClass.simpleName)
        ActivityController.addActivity(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        ActivityController.removeActivity(this)
    }

   fun showMessage(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    fun  showDialog(){

    }
    fun dismissDialog(){

    }

}