package com.example.naturesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import com.example.naturesample.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {
    private lateinit var binding: FragmentLearnBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater,R.layout.fragment_learn,container,false)
        binding.quizButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_learnFragment_to_quizFragment))
        return binding.root
    }}