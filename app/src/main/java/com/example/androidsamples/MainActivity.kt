package com.example.androidsamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener {
            val name = et_student_name.text.toString()
            val lastName = et_student_last_name.text.toString()
            val schoolNumber = et_school_number.text.toString().toInt()
            val classNumber = et_school_class.text.toString().toInt()
            val student = Student(name, lastName, schoolNumber, classNumber)
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_STUDENT", student)
                startActivity(it)
            }

        }
    }
}