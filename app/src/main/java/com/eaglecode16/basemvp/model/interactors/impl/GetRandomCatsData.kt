package com.eaglecode16.basemvp.model.interactors.impl

import com.eaglecode16.basemvp.model.datasource.network.RetrofitClient
import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import com.eaglecode16.basemvp.model.interactors.interfaces.GetRandomCatsInteractor
import com.eaglecode16.basemvp.utils.ApiCallManager
import com.eaglecode16.basemvp.utils.ResourceState


class GetRandomCatsData : GetRandomCatsInteractor {

    private val service by lazy { RetrofitClient.service }

    override suspend fun getRandomCat(): ResourceState<RandomCatResponse> =
        ApiCallManager.callService { service.getRandomCat() }

}