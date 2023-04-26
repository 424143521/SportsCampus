package com.huhaonan.sporscampus.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import android.widget.RadioGroup

class Test : RelativeLayout {
    private var mContext: Context? = null
    private val bp_banner: ViewPager? = null
    private val rg_indicator: RadioGroup? = null

    constructor(context: Context?) : super(context, null) {}
    constructor(context: Context?, attributeSet: AttributeSet?) : super(context, attributeSet) {
        mContext = context
    }
}