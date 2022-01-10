package com.eaglecode16.basemvp.presenter.impl

import com.eaglecode16.basemvp.model.interactors.interfaces.GetRandomCatsInteractor
import com.eaglecode16.basemvp.presenter.interfaces.MeowContract
import com.eaglecode16.basemvp.presenter.interfaces.MeowView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MeowPresenter(private val meowView: MeowView, private val interactor: GetRandomCatsInteractor) :
    MeowContract, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun getRandomCats() {
        launch {
            val response = interactor.getRandomCat()

            meowView.onSuccess(response.url)
        }
    }


}