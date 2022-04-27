package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todo = Todo("Call my mom", true)
        val todos = mutableListOf(
            Todo("Go to School", false),
            Todo("Do homework", true),
            Todo("Drink water", true),
            Todo("Cook dinner", false),
            todo
        )

        val adapter = TodoAdapter(todos)
        rv_todos.adapter = adapter

        btn_add.setOnClickListener {
            val title = et_new_todo.text.toString()
            if(title.isNotEmpty()) {
                val newTodo = Todo(title, false)
                todos.add(newTodo)
                adapter.notifyItemInserted(todos.size-1)
                et_new_todo.setText("")
            }
        }
    }
}