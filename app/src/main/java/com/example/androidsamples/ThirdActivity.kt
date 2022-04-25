package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val student = intent.getSerializableExtra("EXTRA_STUDENT") as Student
        val school = intent.getSerializableExtra("EXTRA_SCHOOL") as School
        finish_text.text = "student info:\n " +
                "${student.name}\n" +
                "${student.lastName}\n" +
                "${student.classNumber}\n" +
                "${student.schoolNumber}\n" +
                "school info\n" +
                "${school.name}\n" +
                "${school.city}"
    }
}