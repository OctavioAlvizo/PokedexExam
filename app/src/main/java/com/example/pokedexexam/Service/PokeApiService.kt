package com.example.pokedexexam.Service

import com.example.pokedexexam.API.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{42}")
    fun getPokemonInfo(@Path("golbat") id: String): Call<Pokemon>
}

