package com.example.my1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val userNameList: List <String> = listOf("Аапр","Кваиаи","Гьптьи","Свапва","Ркарка")

        val usersRecyclerView : RecyclerView = findViewById(R.id.users_r_v)

        usersRecyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        usersRecyclerView.adapter = UserAdapter()


    }
}