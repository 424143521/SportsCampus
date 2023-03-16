package com.huhaonan.sporscampus.util

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.huhaonan.sporscampus.logic.dao.UserDao
import com.huhaonan.sporscampus.logic.roomdatabase.AppDatabase
import com.huhaonan.sporscampus.ui.data.User

//Repository类用来数据的获取，本地云端都可以
class Repository(context: Context) {
    var userDao: UserDao
    var appDatabase: AppDatabase
    var allUserLive: LiveData<List<User>>


    init {
        appDatabase = AppDatabase.getDatabase(context.applicationContext)
        userDao = appDatabase.getUserDao()
        //因为返回的是LiveData类型所以会自动在主线程中操作
        allUserLive = userDao.getAllUsers()


    }

    companion object {
        class InsertAsyncTask(val userDao: UserDao) : AsyncTask<User, Unit, Unit>() {
            //这个方法中的所有代码都会在子线程中运行,我们应该在这里去处理所有的耗时任务
            override fun doInBackground(vararg params: User) {
                userDao.insertUser(params[0])
//                publishProgress();
            }

            //进行ui操作
            override fun onProgressUpdate(vararg values: Unit?) {
                super.onProgressUpdate(*values)
            }

            //这个方法会在后台任务开始执行之前调用,用于进行一些界面上的初始化操作
            override fun onPreExecute() {
                super.onPreExecute()
            }

            //当后台任务执行完毕并通过return语句进行返回时,这个方法就很快会被调用
            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
            }

        }

        class UpdateAsyncTask(val userDao: UserDao) : AsyncTask<User, Unit, Unit>() {
            //这个方法中的所有代码都会在子线程中运行,我们应该在这里去处理所有的耗时任务
            override fun doInBackground(vararg params: User) {
                userDao.updateUser(params[0])
            }
        }

        class DeleteAsyncTask(val userDao: UserDao) : AsyncTask<User, Unit, Unit>() {
            //这个方法中的所有代码都会在子线程中运行,我们应该在这里去处理所有的耗时任务
            override fun doInBackground(vararg params: User) {
                userDao.deleteUser(params[0])
            }
        }

        class DeleteAllAsyncTask(val userDao: UserDao) : AsyncTask<Unit, Unit, Unit>() {
            //这个方法中的所有代码都会在子线程中运行,我们应该在这里去处理所有的耗时任务
            override fun doInBackground(vararg params: Unit?) {
                userDao.deleteAllUsers()
            }
        }

        class SelectAsyncTask(val userDao: UserDao) : AsyncTask<User, Unit, LiveData<User>>(){
            //这个方法中的所有代码都会在子线程中运行,我们应该在这里去处理所有的耗时任务
            override fun doInBackground(vararg params: User):LiveData<User> {
                return userDao.getUser(params[0].account,params[0].passWord)
            }




        }


    }

    fun insertUser(user: User) {
        InsertAsyncTask(userDao).execute(user)
    }

    fun updateUser(user: User) {
        UpdateAsyncTask(userDao).execute(user)
    }

    fun deleteUser(user: User) {
        DeleteAsyncTask(userDao).execute(user)
    }

    fun deleteAllUsers() {
        DeleteAllAsyncTask(userDao).execute()
    }

    fun getUser(user:User):LiveData<User> {
        val user = SelectAsyncTask(userDao).execute(user).get()
        return user
    }


}