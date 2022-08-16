package com.example.rickandmortyapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmortyapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewLogic()

    }

    private fun setUpViewLogic() {
        setUpBottomNavBar()
    }

    private fun setUpBottomNavBar() {
        val navHostFragment: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController: NavController = navHostFragment.findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}