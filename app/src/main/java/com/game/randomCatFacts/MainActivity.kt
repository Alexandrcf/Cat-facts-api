package com.game.randomCatFacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.e.c.R
import com.game.randomCatFacts.data.CatListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var buttonFact: ImageButton
    private lateinit var tvFact: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFact = findViewById(R.id.button_fact)
        tvFact = findViewById(R.id.tv_fact)
        val viewModel = ViewModelProvider(this).get(CatListViewModel::class.java)

        viewModel.listLiveData.observe(this){
            tvFact.text = it.factId
        }

        buttonFact.setOnClickListener {
            viewModel.fetchCatList((application as CatApp).catApi)
        }
    }
}