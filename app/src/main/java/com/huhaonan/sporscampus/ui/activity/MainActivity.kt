package com.huhaonan.sporscampus.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.huhaonan.sporscampus.ui.fragment.ExerciseFragment
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    //抽屉的父布局
    private lateinit var mDrawerLayout: DrawerLayout
    //抽屉
    private lateinit var mNavigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //加载布局
         binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        //初始化
        mDrawerLayout = binding.drawerLayout
        mNavigationView = binding.navView


        //抽屉设置
        binding.navView.apply {
            //默认选中
            setCheckedItem(R.id.navCall)
            //        设置一个菜单选项中事件的监听器 关闭滑动菜单 返回true表示此事件已被处理
            setNavigationItemSelectedListener {
                binding.drawerLayout.closeDrawers()
                true
            }
        }



        // 获取页面上的底部导航栏控件
        val navView : BottomNavigationView = findViewById(R.id.bottomNavigationView);



        // 建立fragment容器的控制器，这个容器就是页面的上的fragment容器
        val navController: NavController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        );

        // 配置navigation与底部菜单之间的联系
        // 底部菜单的样式里面的item里面的ID与navigation布局里面指定的ID必须相同，否则会出现绑定失败的情况
        NavigationUI.setupWithNavController(navView, navController);
    }

    //打开抽屉菜单
    public fun openDraw(){
        mDrawerLayout?.openDrawer(GravityCompat.START)
    }

    //关闭抽屉菜单
    public fun closeDraw(){
        mDrawerLayout?.close()
    }


}