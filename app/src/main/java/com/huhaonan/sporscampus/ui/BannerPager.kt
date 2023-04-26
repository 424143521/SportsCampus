package com.huhaonan.sporscampus.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RadioGroup
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.huhaonan.sportscampus.R

class BannerPager : RelativeLayout {


    private var mContext: Context? = null
    private var vp_banner: ViewPager? = null
    private var rg_indicator: RadioGroup? = null

    constructor(context: Context?) : super(context, null) {}
    constructor(context: Context?, attributeSet: AttributeSet?) : super(context, attributeSet) {
        mContext = context
        initView()
    }



    private fun initView() {
       //根据布局文件banner_pager.xml生成视图对象
        val view = LayoutInflater.from(mContext).inflate(R.layout.banner_pager, null)
        vp_banner = view.findViewById(R.id.vp_banner);
        rg_indicator = view.findViewById(R.id.rg_indicator)
        addView(view)


    }

}