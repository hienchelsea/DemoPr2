package com.example.demopr21010.coroutine

import retrofit2.Response
import java.io.IOException

open class HandersApiResult {

    suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): ResultCoroutines<T> {
        val response = call.invoke()
        if (response.isSuccessful) return ResultCoroutines.Success(response.body()!!)
        return ResultCoroutines.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}