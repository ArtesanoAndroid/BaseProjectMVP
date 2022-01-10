package com.eaglecode16.basemvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eaglecode16.basemvp.R
import com.eaglecode16.basemvp.model.datasource.network.RetrofitClient
import com.eaglecode16.basemvp.model.interactors.impl.GetRandomCatsData
import com.eaglecode16.basemvp.presenter.impl.MeowPresenter
import com.eaglecode16.basemvp.presenter.interfaces.MeowView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 *
 */
class MeowActivity : AppCompatActivity(), MeowView, CoroutineScope {

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val presenter by lazy { MeowPresenter(this, GetRandomCatsData(RetrofitClient.service)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            presenter.getRandomCats()
        }
    }

    override fun onSuccess(url: String) {

    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }
}