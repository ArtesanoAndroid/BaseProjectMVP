package com.eaglecode16.basemvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import coil.load
import com.eaglecode16.basemvp.databinding.ActivityMainBinding
import com.eaglecode16.basemvp.presenter.implementations.MeowPresenter
import com.eaglecode16.basemvp.presenter.interfaces.MeowView

/**
 *
 */
class MeowActivity : AppCompatActivity(), MeowView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by lazy { MeowPresenter(this) }

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

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }


    override fun onSuccess(url: String) {
        binding.ivCats.load(url)
    }

    override fun onFailure(msg: String) {
        Toast.makeText(this@MeowActivity, msg, Toast.LENGTH_LONG).show()
    }

}