package com.huhaonan.sporscampus.ui.fragment

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.huhaonan.sporscampus.util.SportsCampusApplication
import com.huhaonan.sporscampus.ui.adapter.FruitAdapter
import com.huhaonan.sporscampus.ui.data.Fruit
import com.huhaonan.sportscampus.R
import com.huhaonan.sporscampus.ui.viewmodel.SchoolViewModel
import com.huhaonan.sportscampus.databinding.FragmentSchoolBinding
import kotlin.concurrent.thread

class SchoolFragment : Fragment() {

    //初始化
    val fruits = mutableListOf(Fruit("Apple", R.drawable.double_runner),Fruit("Banana",
        R.drawable.endless_runner
    ))

    lateinit var swipeRefresh: SwipeRefreshLayout
    val fruitList = ArrayList<Fruit>()
    lateinit var binding:FragmentSchoolBinding

    private lateinit var viewModel: SchoolViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_school,container,false)
        binding.fab.setOnClickListener {
            //            Toast.makeText(this,"悬浮按钮",Toast.LENGTH_LONG).show()
            Snackbar.make(it,"Snackbar提示",Snackbar.LENGTH_SHORT).setAction("点击"){
                Toast.makeText(activity,"Snackbar被点击",Toast.LENGTH_LONG).show()
            }.show()
        }
        swipeRefresh = binding.swipeRefresh
        initFruits()
        val recyclerView =binding.recyclerView
        val layoutManager = GridLayoutManager(SportsCampusApplication.context,2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(SportsCampusApplication.context, fruitList)
        recyclerView.adapter = adapter
        swipeRefresh.setOnRefreshListener {
            refreshAdapter(adapter)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = binding.toolBar
        val appCompatActivity  = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolbar)
        val supportActionBar = appCompatActivity?.supportActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.title = "打卡校园"

    }
    private fun refreshAdapter(adapter: FruitAdapter) {
        thread {
            Thread.sleep(2000)
            activity?.runOnUiThread {
                initFruits()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing =false
            }

        }
    }


    //随机数据
    private fun initFruits(){
        fruitList.clear()
        repeat(50){
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

}