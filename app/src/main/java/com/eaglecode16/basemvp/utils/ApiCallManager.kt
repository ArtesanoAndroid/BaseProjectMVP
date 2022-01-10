package com.eaglecode16.basemvp.utils


object ApiCallManager {

    suspend fun <T> callService(apiCall: suspend () -> T): ResourceState<T> {
        return try {
            ResourceState.Success(apiCall.invoke())
        } catch (exception: Exception) {
            ResourceState.Error(exception.message ?: "")
        }
    }
}