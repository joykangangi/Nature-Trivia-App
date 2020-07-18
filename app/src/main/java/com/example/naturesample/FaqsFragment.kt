package com.example.naturesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.naturesample.databinding.FragmentFaqsBinding
import com.example.naturesample.databinding.FragmentGameOverBinding

class FaqsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFaqsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_faqs, container, false)
        return binding.root
    }}