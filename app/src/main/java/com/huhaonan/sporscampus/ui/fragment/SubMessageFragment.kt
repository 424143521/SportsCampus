package com.huhaonan.sporscampus.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.huhaonan.sportscampus.R

class SubMessageFragment: Fragment(R.layout.fragment_message_left) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = savedInstanceState!!.getString("tab")

    }
}