package com.example.my1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

private const val TAG = 'MyActivity'
private const val VALUE = 'ключик1'

class MainActivity : AppCompatActivity() {
    private lateinit var helloTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helloTV: TextView = findViewById(R.id.TV_hello)
        /*helloTV.text = R.string.hello*/
        val buttonChange: Button = findViewById(R.id.button_change)
        buttonChange.setOnClickListener {

        }

        Log.d ( TAG ,  "onCr")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALUE)
    }
}