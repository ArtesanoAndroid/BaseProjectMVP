package com.eaglecode16.basemvp.model.interactors.interfaces

import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse


/**
 *
 */
interface GetRandomCatsInteractor {

    suspend fun getRandomCat(): RandomCatResponse
}