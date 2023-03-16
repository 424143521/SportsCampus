package com.huhaonan.sporscampus.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.FragmentExerciseBinding

import com.huhaonan.sporscampus.ui.viewmodel.ExerciseViewModel

class ExerciseFragment : Fragment() {

    companion object {
        fun newInstance() = ExerciseFragment()
    }

    private lateinit var viewModel: ExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val binding = DataBindingUtil.inflate<FragmentExerciseBinding>(inflater,R.layout.fragment_exercise,container,false)




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



}