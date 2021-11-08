package com.example.my1

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.EditText


private const val TAG = "MyActivity"
private const val KEY1 = "ключик1"
private const val KEY2 = "ключик2"

class MainActivity : AppCompatActivity() {
    private lateinit var helloTV: TextView
    private lateinit var byeTV: TextView
    private lateinit var buttonChange: Button
    private lateinit var keyText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTV  = findViewById(R.id.TV_hello)
        byeTV = findViewById(R.id.TV_bye)
        buttonChange = findViewById(R.id.button_change)
        keyText = findViewById(R.id.key_text)
        if (savedInstanceState != null) {
            helloTV.text = savedInstanceState.getString(KEY1)
            keyText.setText(savedInstanceState.getString(KEY2,""))
        }

        buttonChange.setOnClickListener { change() }

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            byeTV.text = "вертикальная"
        else
            byeTV.text =  "горизонтальная"

        Log.d ( TAG ,  "Create \nТы видел деву на скале\n" +
                "В одежде белой над волнами")
    }

    private fun change() {
         helloTV.text = kotlin.random.Random.nextInt(1000).toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Start \nКогда, бушуя в бурной мгле,\n" +
                "Играло море с берегами,")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Resume \nКогда луч молний озарял\n" +
                "Ее всечасно блеском алым")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Pause \nИ ветер бился и летал\n" +
                "С ее летучим покрывалом? ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Stop \nПрекрасно море в бурной мгле\n" +
                "И небо в блесках без лазури;")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Destroy \nНо верь мне: дева на скале\n" +
                "Прекрасней волн, небес и бури.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString (KEY1,helloTV.text.toString())
            putString (KEY2,keyText.getText().toString())
        }
    }

}

