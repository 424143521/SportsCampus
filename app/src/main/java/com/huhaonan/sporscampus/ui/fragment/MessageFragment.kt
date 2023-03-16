package com.huhaonan.sporscampus.ui.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.button.MaterialButton
import com.huhaonan.sportscampus.R
import com.huhaonan.sportscampus.databinding.FragmentMessageBinding
import com.huhaonan.sporscampus.ui.viewmodel.DynamicViewModel

class MessageFragment : Fragment() {

  private lateinit var binding:FragmentMessageBinding
    private lateinit var viewModel: DynamicViewModel
    private var tab1Fragment:BlankFragment? = null
    private var tab2Fragment:BlankFragment? = null
    private var shownFragment:Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_message,container,false)


        binding.toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            //查看有几个子按钮
            val childCount: Int = group.childCount
            //选择fragment的id
            var selectIndex = 0
            for ( index  in 0 until childCount){
                val button = group.getChildAt(index) as MaterialButton
                if (button.id == checkedId){
                    Log.d("页面","$checkedId")
                    selectIndex = index
                    button.setTextColor(Color.RED)
                    button.iconTint = ColorStateList.valueOf(Color.RED)
                }else{
                    button.setTextColor(Color.BLACK)
                    button.iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }
            swichFragment(selectIndex)

        }

        binding.toggleGroup.check(R.id.topButton1)
        return binding.root
   }

//选择显示哪个fragment
    fun swichFragment(selectIndex:Int){


        val fragment: BlankFragment? = when(selectIndex){
            0 ->{
                if (tab1Fragment == null) {
                    tab1Fragment = BlankFragment()
                    val bundle = Bundle()
                    bundle.putString("tab","tab1")
                    tab1Fragment!!.arguments = bundle
                }
                tab1Fragment
            }
            1 ->{
                if (tab2Fragment == null) {
                    tab2Fragment = BlankFragment()
                    val bundle = Bundle()
                    bundle.putString("tab","tab2")
                    tab2Fragment!!.arguments =bundle
                }
                tab2Fragment
            }
            else -> {
                throw IllegalAccessException("下标不符合预期")
            }
        }?:return

    //开启事务
        val ft:FragmentTransaction =  requireActivity().supportFragmentManager.beginTransaction()
//判断之前有没有被添加过
    if(!(fragment?.isAdded)!!){
            ft.add(R.id.frameLayout,fragment)
        }
        ft.show(fragment)
    //如果之前有fragment显示则把之前的给隐藏掉
        if(shownFragment!=null){
            ft.hide(shownFragment!!)
        }
    //存储下当前显示的fragment
        shownFragment =fragment
    //提交事务
        ft.commitAllowingStateLoss()
    }

 /*   */



}