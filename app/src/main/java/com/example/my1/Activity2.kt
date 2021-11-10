package com.example.my1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

private const val KEY2 = "ключик2"

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val hello = intent.extras?.getString(KEY2)

        Toast.makeText(this, "hello" , Toast.LENGTH_LONG).show()
    }
}