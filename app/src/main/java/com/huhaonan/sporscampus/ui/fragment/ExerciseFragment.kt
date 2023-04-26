package com.huhaonan.sporscampus.ui.fragment

import android.app.Activity
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.huhaonan.sporscampus.ui.activity.MainActivity
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.FragmentExerciseBinding

import com.huhaonan.sporscampus.ui.viewmodel.ExerciseViewModel

class ExerciseFragment : Fragment() {

    companion object {
        fun newInstance() = ExerciseFragment()
    }

    private lateinit var viewModel: ExerciseViewModel
    //顶部导航
    lateinit var mToolbar: Toolbar
    lateinit var mainActivity : MainActivity
    private var appCompatActivity: AppCompatActivity? = null
    //抽屉的父布局
    private  var mDrawerLayout: DrawerLayout? = null
    //抽屉
    private lateinit var mNavigationView: NavigationView
    lateinit var binding: FragmentExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = DataBindingUtil.inflate(inflater,R.layout.fragment_exercise,container,false)



//给viewPager2添加适配器
             binding.viewPager2.adapter = object :FragmentStateAdapter(this){
            //告诉viewPage里面有几个页面
            override fun getItemCount()=3
            //每一个位置要创建哪一个页面给它
            override fun createFragment(position: Int) =
                when (position){
                    0 -> EventFragment()
                    1 -> MyExerciseFragment()
                    else -> RankingFragment()
                }


        }
            //将tablayout和viewPager关联起来,第三个参数为处理方式
        TabLayoutMediator(binding.tablayout,binding.viewPager2) { tab, position ->
            when(position){
                0 -> tab.text = "赛程"
                1 -> tab.text = "我的运动"
                else -> tab.text ="排行"
            }
        }.attach()


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appCompatActivity  = activity as AppCompatActivity?
         mainActivity = activity as MainActivity

        /*   mNavigationView = activity.findViewById(R.id.navView)
        mDrawerLayout = activity.findViewById(R.id.drawerLayout)
           println("view是"+ view)
           println("activity是"+activity)*/
        mToolbar = view.findViewById(R.id.tool_bar)
        mToolbar.inflateMenu(R.menu.message_toolbar);
        mToolbar.setTitle("自律打卡")
        mToolbar.logo=  getResources().getDrawable(R.drawable.exercise,null)
        appCompatActivity?.setSupportActionBar(mToolbar)
//        mDrawerLayout.open()
        //决定左上角的图标是否可以点击。
        appCompatActivity?.supportActionBar?.setHomeButtonEnabled(true)
        //该方法是 决定左上角图标的右侧是否有向左的小箭头。
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mToolbar.setNavigationOnClickListener {
            Toast.makeText(activity,"哈哈",Toast.LENGTH_SHORT).show()
            mainActivity.openDraw()
        }

    }

/*    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        mainActivity.openDraw()
        when(item.itemId){
            android.R.id.home ->{
                Toast.makeText(activity,"哈哈",Toast.LENGTH_SHORT).show()

                true
            }
            else -> false
        }
        return super.onOptionsItemSelected(item)
    }*/

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar,menu)

    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

    }



}