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

        val options = arrayOf("First", "Second", "Third")
        val dialog2 = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You clicked ${options[i]}", Toast.LENGTH_SHORT).show()

            }
            .setPositiveButton("Approve") { _, _ ->
                Toast.makeText(this, "Approved", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }
            .create()
        
        btn_dialog2.setOnClickListener {
            dialog2.show()
        }

        val dialog3 = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}" , Toast.LENGTH_SHORT).show()
                }  else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Approve") { _, _ ->
                Toast.makeText(this, "Approved", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }
            .create()
        btn_dialog3.setOnClickListener {
            dialog3.show()
        }
    }
}