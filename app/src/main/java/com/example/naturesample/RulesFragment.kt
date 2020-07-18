package com.example.naturesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.naturesample.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {
private lateinit var binding:FragmentRulesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_rules,container,false
        )
        return binding.root
    }

}