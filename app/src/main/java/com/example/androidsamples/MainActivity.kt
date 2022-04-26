package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog1 = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_add)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr Can to your contacts?")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Mr. Can to your contacts", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You didn't add Mr. Can to your contacts", Toast.LENGTH_SHORT).show()
            }
            .create()

        btn_dialog1.setOnClickListener {
            dialog1.show()
        }

    }
}