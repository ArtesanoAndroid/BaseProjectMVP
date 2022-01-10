package com.eaglecode16.basemvp.utils

sealed class ResourceState<out T> {
    data class Success<out T>(val data: T) : ResourceState<T>()
    data class Error(val errorMessage: String) : ResourceState<Nothing>()
}