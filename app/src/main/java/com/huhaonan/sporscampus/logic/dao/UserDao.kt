package com.huhaonan.sporscampus.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.huhaonan.sporscampus.ui.data.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long

    @Update
    fun updateUser(user: User)

    @Query("select * from user where account = :account and passWord = :passWord ")
    fun getUser(account: String, passWord: String):LiveData<User>

    @Query("select * from USER ORDER BY ID DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Delete
    fun deleteUser(user:User)

    @Query("DELETE FROM USER")
    fun deleteAllUsers()
}
