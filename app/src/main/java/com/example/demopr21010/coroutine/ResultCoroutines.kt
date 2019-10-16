package com.example.demopr21010.coroutine

sealed class ResultCoroutines<out T: Any> {
    data class Success<out T : Any>(val data: T) : ResultCoroutines<T>()
    data class Error(val exception: Exception) : ResultCoroutines<Nothing>()
}