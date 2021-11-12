package com.example.my1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

private const val KEY2 = "ключик2"

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val hello = intent.extras?.getString(KEY2)
        Toast.makeText(this, "hello" , Toast.LENGTH_LONG).show()

        val buttonSnack: Button = findViewById(R.id.button_snack)
        buttonSnack.setOnClickListener {
            showSnackbar(it)
            Toast.makeText(this,"листенер",Toast.LENGTH_LONG).show()
        }

    }

    private fun showSnackbar    (   view:  View  ) {
        Toast.makeText(this,"функция",Toast.LENGTH_LONG).show()
        Snackbar.make(this,view,"Мой снэкбар",Snackbar.LENGTH_INDEFINITE)
            .setAction("Актион") {
                Toast.makeText(this,"Тостик",Toast.LENGTH_LONG).show()
                    }
            .show()
    }
}