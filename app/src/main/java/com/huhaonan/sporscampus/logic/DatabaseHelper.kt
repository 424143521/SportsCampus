package com.huhaonan.sporscampus.logic

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DatabaseHelper {

    private var connection:Connection? = null
    fun getConnection(): Connection? {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver") //固定格式，不能变
                Log.e("驱动加载", "succeed")
                connection = DriverManager.getConnection(
                    "jdbc:mysql://192.168.77.250:3306/student",
                    "root",
                    "123456"
                )
                Log.e("数据库连接", "succeed")
            } catch (e: ClassNotFoundException) {
                Log.e("数据库连接", "fail")
                e.printStackTrace()
            } catch (e: SQLException) {
                Log.e("数据库连接", "fail")
                e.printStackTrace()
            }
        }
        return connection
    }

    fun closeConnection() {
        if (connection != null) {
            try {
                connection!!.close()
                Log.e("数据库关闭", "succeed")
            } catch (throwables: SQLException) {
                throwables.printStackTrace()
                Log.e("数据库关闭", "fail")
            }
        }
    }
}

