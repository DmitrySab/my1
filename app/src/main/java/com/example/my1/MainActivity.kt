package com.example.my1

//import androidx.activity.result.contract.ActivityResultContracts
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.*


private const val TAG = "MyActivity"
private const val KEY1 = "ключик1"
private const val KEY2 = "ключик2"
private const val GET_FILE_REQUEST = 1

class MainActivity : AppCompatActivity() {
    private lateinit var helloTV: TextView
    private lateinit var byeTV: TextView
    private lateinit var buttonChange: Button
    private lateinit var keyText: EditText
    private lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTV  = findViewById(R.id.TV_hello)
        byeTV = findViewById(R.id.TV_bye)
        buttonChange = findViewById(R.id.button_change)
        val buttonNext: Button = findViewById(R.id.button_next)
        val buttonLink: Button = findViewById(R.id.button_link)
        val buttonSend: ImageButton = findViewById(R.id.button_send)
        val buttonMap: ImageButton = findViewById(R.id.button_map)
        keyText = findViewById(R.id.key_text)
       /* if (savedInstanceState != null) {
            helloTV.text = savedInstanceState.getString(KEY1)
            keyText.setText(savedInstanceState.getString(KEY2,""))
        }*/

        buttonChange.setOnClickListener { change() }

        val intent = Intent(this,ActivityRecyclerView::class.java)
        //intent.putExtra(KEY2,keyText.getText().toString())

        buttonNext.setOnClickListener{
            startActivity(intent)
        }
        //val link = Uri.parse(keyText.getText().toString())
        //val intent2 = Intent(Intent.ACTION_VIEW,link)

        //val intent2 = Intent( Intent.ACTION_GET_CONTENT)
        //intent2.type = "file/*"

        //val youtubelink = Uri.parse("vnd.youtube://" + keyText.getText().toString())
        val intent2 = Intent(Intent.ACTION_HEADSET_PLUG)
        //intent2.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        buttonLink.setOnClickListener {
            if(intent2.resolveActivity(packageManager)!=null)
                startActivity(intent2)
            else
                Toast.makeText(this,"Ашипка",Toast.LENGTH_LONG).show()
        }

     /*  val intent2 = Intent(Intent.ACTION_GET_CONTENT)
        intent2.type = "file/*"
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        }
        buttonLink.setOnClickListener {
            startActivityForResult(intent2, GET_FILE_REQUEST)
        }*/  */

        val intent3 = Intent(Intent.ACTION_SEND)
        intent3.type = "text/plain"
        intent3.putExtra(Intent.EXTRA_TEXT,keyText.getText().toString() )
        val chooser = Intent.createChooser(intent3,"поделиться123")
        buttonSend.setOnClickListener{
            startActivity(chooser)
        }

        buttonMap.setOnClickListener{
        val geoUriString = "geo:56,58;u=45"
        val geoUri:Uri = Uri.parse(geoUriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }
        }

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
        Log.d(TAG, "Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Pause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Stop ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Destroy ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString (KEY1,helloTV.text.toString())
            putString (KEY2,keyText.getText().toString())
        }
    }

}

