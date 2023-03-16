package com.huhaonan.sporscampus.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )

      setSupportActionBar(binding.dynamicToolbar)
  /*      binding.dynamicToolbar.apply {

            inflateMenu(R.menu.message_toolbar);
        }*/
        supportActionBar?.let {
            //显示导航按钮
            it.setDisplayHomeAsUpEnabled(true)
//            设置导航图标
            it.setHomeAsUpIndicator(R.drawable.person_icon)
        }

        binding.navView.apply {
            //默认选中
            setCheckedItem(R.id.navCall)
            //        设置一个菜单选项中事件的监听器 关闭滑动菜单 返回true表示此事件已被处理
            setNavigationItemSelectedListener {
                binding.drawerLayout.closeDrawers()
                true
            }
        }

        binding.fab.setOnClickListener {
//            Toast.makeText(this,"悬浮按钮",Toast.LENGTH_LONG).show()
            Snackbar.make(it,"Snackbar提示",Snackbar.LENGTH_SHORT).setAction("点击"){
                Toast.makeText(this,"Snackbar被点击",Toast.LENGTH_LONG).show()
            }.show()
        }

        // 获取页面上的底部导航栏控件
        val navView : BottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 配置navigation与底部菜单之间的联系
        // 底部菜单的样式里面的item里面的ID与navigation布局里面指定的ID必须相同，否则会出现绑定失败的情况
        val appBarConfiguration :AppBarConfiguration =  AppBarConfiguration.Builder(
            R.id.exerciseFragment,R.id.schoolFragment,R.id.messageFragment,R.id.personageFragment)
            .build();
        // 建立fragment容器的控制器，这个容器就是页面的上的fragment容器
        val navController: NavController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        );

        // 启动
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.message_toolbar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //打开滑动菜单
            android.R.id.home -> {binding.drawerLayout.openDrawer(GravityCompat.START)}
            R.id.add_friends-> {
                Toast.makeText(this,"加好友",Toast.LENGTH_LONG).show()}
            R.id.scan -> {}
            R.id.servicer -> {}
            R.id.setting -> {}

        }
        return true
    }


}