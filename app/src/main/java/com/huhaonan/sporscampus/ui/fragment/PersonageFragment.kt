package com.huhaonan.sporscampus.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huhaonan.sportscampus.R
import com.huhaonan.sporscampus.ui.viewmodel.PersonageViewModel

class PersonageFragment : Fragment() {

    companion object {
        fun newInstance() = PersonageFragment()
    }

    private lateinit var viewModel: PersonageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}