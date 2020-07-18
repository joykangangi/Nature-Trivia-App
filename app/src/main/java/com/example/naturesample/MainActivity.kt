package com.example.naturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.naturesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var drawerLayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
       drawerLayout=binding.drawerLayout
        val navController=this.findNavController(R.id.myNavHostFragment)//find nav controller obj
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)//link nav controller to app bar

            NavigationUI.setupWithNavController(binding.navView,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
    }
