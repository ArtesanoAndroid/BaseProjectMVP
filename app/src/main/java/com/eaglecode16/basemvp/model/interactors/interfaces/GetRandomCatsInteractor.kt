package com.eaglecode16.basemvp.model.interactors.interfaces

import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import com.eaglecode16.basemvp.utils.ResourceState


/**
 *
 */
interface GetRandomCatsInteractor {

    suspend fun getRandomCat(): ResourceState<RandomCatResponse>
}