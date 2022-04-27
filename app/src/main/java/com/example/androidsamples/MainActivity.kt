package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val messageFragment = MessageFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(homeFragment)

        bottom_nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mi_home ->setCurrentFragment(homeFragment)
                R.id.mi_message ->setCurrentFragment(messageFragment)
                R.id.mi_profile ->setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_container,fragment)
            commit()
        }
    }
}