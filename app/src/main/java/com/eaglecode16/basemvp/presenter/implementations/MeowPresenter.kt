package com.eaglecode16.basemvp.presenter.implementations

import com.eaglecode16.basemvp.model.interactors.impl.GetRandomCatsData
import com.eaglecode16.basemvp.presenter.interfaces.MeowContract
import com.eaglecode16.basemvp.presenter.interfaces.MeowView
import com.eaglecode16.basemvp.utils.ResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MeowPresenter(
    private val meowView: MeowView
) :
    MeowContract, CoroutineScope {

    private val interactor by lazy { GetRandomCatsData() }

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun getRandomCats() {
        launch {

            meowView.showLoading()

            when (val response = interactor.getRandomCat()) {
                is ResourceState.Success -> {
                    meowView.hideLoading()
                    meowView.onSuccess(response.data.url)
                }
                is ResourceState.Error -> {
                    meowView.hideLoading()
                    meowView.onFailure(response.errorMessage)
                }
            }
        }
    }


}