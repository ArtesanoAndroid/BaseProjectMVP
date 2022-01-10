package com.eaglecode16.basemvp.presenter.impl

import com.eaglecode16.basemvp.model.interactors.interfaces.GetRandomCatsInteractor
import com.eaglecode16.basemvp.presenter.interfaces.MeowContract
import com.eaglecode16.basemvp.presenter.interfaces.MeowView

class MeowPresenter(val meowView: MeowView, val interactor: GetRandomCatsInteractor) :
    MeowContract {

    override suspend fun getRandomCats() {

        val url = interactor.getRandomCat()
    }
}