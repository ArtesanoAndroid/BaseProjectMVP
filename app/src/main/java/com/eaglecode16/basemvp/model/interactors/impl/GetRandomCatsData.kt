package com.eaglecode16.basemvp.model.interactors.impl

import com.eaglecode16.basemvp.model.datasource.network.RetrofitClient
import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import com.eaglecode16.basemvp.model.interactors.interfaces.GetRandomCatsInteractor
import com.eaglecode16.basemvp.utils.State
import java.lang.Exception

/**
 *
 */
class GetRandomCatsData : GetRandomCatsInteractor {

    private val service by lazy { RetrofitClient.service }

    override suspend fun getRandomCat(): State<RandomCatResponse> {
        val result = service.getRandomCat()

        return try {
            State.Success(result)
        } catch (exception: Exception) {
            State.Error(exception.message ?: "")
        }
    }
}