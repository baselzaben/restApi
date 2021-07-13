package com.baselalzaben.task.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baselalzaben.task.Adapters.CarsAdapter
import com.baselalzaben.task.Models.Cars
import com.baselalzaben.task.R
import com.baselalzaben.task.Services.ServiceBuilder
import com.baselalzaben.task.Services.CarsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            loadCountries()
        }


        private fun loadCountries() {
//
            var country_recycler = findViewById<RecyclerView>(R.id.country_recycler)
            val destinationService  = ServiceBuilder.buildService(CarsService::class.java)
            val requestCall =destinationService.getAffectedCountryList()

            requestCall.enqueue(object : Callback<List<Cars>>{
                override fun onResponse(call: Call<List<Cars>>, response: Response<List<Cars>>) {
                    Log.d("Response", "onResponse: ${response.body()}")
                    System.out.print("tttt"+response.body())
                    if (response.isSuccessful){
                        val countryList  = response.body()!!
                        Log.d("Response", "countrylist size : ${countryList.size}")
                        country_recycler.apply {
                            setHasFixedSize(true)
                            layoutManager = GridLayoutManager(this@MainActivity,1)
                             adapter = CarsAdapter(response.body()!!)
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<List<Cars>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
                }
            })
        }
    } }