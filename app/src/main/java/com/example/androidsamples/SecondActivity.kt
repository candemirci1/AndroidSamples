package com.example.androidsamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val student = intent.getSerializableExtra("EXTRA_STUDENT") as Student

        btn_finish.setOnClickListener {
            val schoolName = et_school_name.text.toString()
            val city = et_city.text.toString()
            val school = School(schoolName, city)
            Intent(this, ThirdActivity::class.java ).also {
                it.putExtra("EXTRA_SCHOOL", school)
                it.putExtra("EXTRA_STUDENT", student)
                startActivity(it)
            }

        }
    }
}