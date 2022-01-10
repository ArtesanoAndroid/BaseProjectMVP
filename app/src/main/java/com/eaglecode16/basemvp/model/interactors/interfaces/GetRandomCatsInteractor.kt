package com.eaglecode16.basemvp.model.interactors.interfaces

import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import com.eaglecode16.basemvp.utils.State
import java.util.*


/**
 *
 */
interface GetRandomCatsInteractor {

    suspend fun getRandomCat(): State<RandomCatResponse>
}