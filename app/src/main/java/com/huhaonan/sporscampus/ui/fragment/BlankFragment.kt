package com.huhaonan.sporscampus.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huhaonan.sportscampus.R


class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tab = arguments?.getString("tab")
        if (tab =="tab1"){
            return inflater.inflate(R.layout.fragment_message_left, container, false)
        }else
        {
            return inflater.inflate(R.layout.fragment_message_right, container, false)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_right, container, false)

    }


}