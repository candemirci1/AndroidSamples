package com.example.androidsamples

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        btn_save.setOnClickListener {
            val name = et_name.text.toString()
            val age = et_age.text.toString().toInt()
            val isAdult = cb_adult.isChecked

            editor.apply {
                putString("name",name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }


        }

        btn_load.setOnClickListener {
            val name = sharedPreferences.getString("name", null)
            val age = sharedPreferences.getInt("age", 0)
            val isAdult = sharedPreferences.getBoolean("isAdult", false)
            et_name.setText(name)
            et_age.setText(age.toString())
            cb_adult.isChecked = isAdult
        }

    }


}