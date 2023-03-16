package com.huhaonan.sporscampus.logic.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.huhaonan.sporscampus.logic.dao.UserDao
import com.huhaonan.sporscampus.ui.data.User

@Database(entities = [User::class],version =1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object  {
        /*val MIGRATION_2_3 = object : Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE User ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1")
            }

        }*/
        private var instance: AppDatabase? = null
        @Synchronized
         fun  getDatabase(context: Context): AppDatabase {
            return instance?.let { it }
                ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
//                        数据库迁移
//                    .addMigrations(MIGRATION_2_3)
//破坏式重建数据库
//                    .fallbackToDestructiveMigration()
                    .build()
                    .apply { instance = this }
        }
    }
}
