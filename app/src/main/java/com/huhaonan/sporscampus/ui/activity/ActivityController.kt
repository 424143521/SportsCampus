package com.huhaonan.sporscampus.ui.activity

import android.app.Activity

object ActivityController {
    //单例类只需要一个Activity集合，通过ArrayList进行暂存
    private val activities = ArrayList<Activity>()

    //向ArrayList中添加
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    //移除Activity
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    //用于将所有Activity销毁
    fun finishAll() {
        for (activity in activities) {
            //需要判断Activity是否正处于销毁状态
            if (!activity.isFinishing)
            //最后进行销毁
                activity.finish()
        }
        activities.clear()
    }
}