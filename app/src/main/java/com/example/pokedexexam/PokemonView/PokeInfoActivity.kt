package com.example.pokedexexam.PokemonView;


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexexam.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pokeinfo.*

class PokeInfoActivity : AppCompatActivity() {

    private lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokeinfo)

        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)

        initUI()
    }

    private fun initUI(){

        val id = intent.extras?.get("golbat") as String

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            nameTextView.text = pokemon.name
            heightText.text = "Altura: ${pokemon.height/10.0}m"
            weightText.text = "Peso: ${pokemon.weight/10.0}"
            MovesText.text = "Movimientos: ${pokemon.moves/10.0}"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(imageView)
        })
    }
}