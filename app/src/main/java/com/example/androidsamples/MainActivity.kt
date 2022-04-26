package com.example.androidsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ic_settings -> Toast.makeText(this, "Selected Settings", Toast.LENGTH_SHORT).show()
            R.id.ic_add_person -> Toast.makeText(this, "Selected Add Person", Toast.LENGTH_SHORT).show()
            R.id.ic_favorite -> Toast.makeText(this, "Selected Favorite" , Toast.LENGTH_SHORT).show()
            R.id.ic_close -> finish()
        }
        return true
    }
}