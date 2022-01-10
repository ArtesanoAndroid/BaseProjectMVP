package com.eaglecode16.basemvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.eaglecode16.basemvp.databinding.ActivityMainBinding
import com.eaglecode16.basemvp.model.datasource.network.RetrofitClient
import com.eaglecode16.basemvp.model.interactors.impl.GetRandomCatsData
import com.eaglecode16.basemvp.presenter.impl.MeowPresenter
import com.eaglecode16.basemvp.presenter.interfaces.MeowView

/**
 *
 */
class MeowActivity : AppCompatActivity(), MeowView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by lazy { MeowPresenter(this, GetRandomCatsData(RetrofitClient.service)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter.getRandomCats()
        uiEvents()
    }

    private fun uiEvents() {
        binding.btnShowAnotherCat.setOnClickListener {
            presenter.getRandomCats()
        }
    }

    override fun onSuccess(url: String) {
        binding.ivCats.load(url)
    }

    override fun onFailure() {

    }
}