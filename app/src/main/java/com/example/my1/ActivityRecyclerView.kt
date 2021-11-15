package com.example.my1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        /*val userNameList: List <String> = listOf("Аапр","Кваиаи","Гьптьи","Свапва","Ркарка","Аапр","Кваиаи","Гьптьи","Свапва","Ркарка","Аапр","Кваиаи","Гьптьи","Свапва","Ркарка","Аапр","Кваиаи","Гьптьи","Свапва","Ркарка")
        val usersRecyclerView : RecyclerView = findViewById(R.id.users_r_v)

        usersRecyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        usersRecyclerView.adapter = UserAdapter(userNameList)*/

        val cityList :List<City> = listOf(
            City("Moskow",12_600_000,"37,45,55,56"),
            City("Sankt-Peterburg",5_300_000,"59.94, 30.31"),
            City("Kazan",1_200_000,"55.79, 49.12"),
            City("Tomsk",580_000,"56.5, 84.97"),
            City("Pyatigorsk",146_000,"44.04, 43.03"),
        )
        val cityRecyclerView : RecyclerView = findViewById(R.id.users_r_v)
        cityRecyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        cityRecyclerView.adapter = CityAdapter(cityList)
        cityRecyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL))


    }
}