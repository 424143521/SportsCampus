package com.huhaonan.sporscampus.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(@ColumnInfo(name ="account") var account: String, var passWord: String) {


    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}
