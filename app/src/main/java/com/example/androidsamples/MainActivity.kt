package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = FirstFragment()
        val fragment2 = SecondFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment1)
            addToBackStack(null)
            commit()
        }

        btn_first.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, fragment1)
                addToBackStack(null)
                commit()
            }
        }
        btn_second.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, fragment2)
                addToBackStack(null)
                commit()
            }
        }
    }
}