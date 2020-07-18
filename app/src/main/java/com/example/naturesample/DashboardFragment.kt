package com.example.naturesample

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.naturesample.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {
    private lateinit var binding:FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard,container,false)
       binding.cardLearn.setOnClickListener(
    Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_learnFragment)
)
        binding.cardFaqs.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_faqsFragment)
        )
        binding.cardMore.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_moreFragment)
        )
        binding.cardQuiz.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_quizFragment)
        )

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}
