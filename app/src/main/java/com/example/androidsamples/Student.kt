package com.example.androidsamples

import java.io.Serializable

data class Student(
    val name: String,
    val lastName: String,
    val schoolNumber: Int,
    val classNumber: Int
) : Serializable