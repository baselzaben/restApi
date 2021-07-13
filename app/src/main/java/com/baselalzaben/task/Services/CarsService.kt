package com.baselalzaben.task.Services

import com.baselalzaben.task.Models.Cars
import retrofit2.Call
import retrofit2.http.GET

interface CarsService {

    @GET("data")
    fun getAffectedCountryList () : Call<List<Cars>>
}