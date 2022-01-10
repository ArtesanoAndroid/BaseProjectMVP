package com.eaglecode16.basemvp.model.interactors.impl

import com.eaglecode16.basemvp.model.datasource.network.RetrofitClient
import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import com.eaglecode16.basemvp.model.interactors.interfaces.GetRandomCatsInteractor

/**
 *
 */
class GetRandomCatsData(private val service: RetrofitClient.MeowService) : GetRandomCatsInteractor {

    override suspend fun getRandomCat(): RandomCatResponse = service.getRandomCat()
}