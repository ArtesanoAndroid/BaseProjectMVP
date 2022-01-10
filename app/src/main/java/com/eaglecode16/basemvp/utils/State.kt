package com.eaglecode16.basemvp.utils

import java.lang.Exception

sealed class State<out T> {
    data class Success<out T>(val data: T) : State<T>()
    data class Error(val errorMessage: String) : State<Nothing>()
}