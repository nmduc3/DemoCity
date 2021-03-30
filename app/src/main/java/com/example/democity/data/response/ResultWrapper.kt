package com.example.democity.data.response

import java.io.IOException

/**
 * Created by nmduc3 on 3/30/21
 */
sealed class ResultWrapper<T> {
    data class Success<T>(val value: T) : ResultWrapper<T>()

    data class GenericError<T>(val code: Int, val message: String) : ResultWrapper<T>()

    data class NetworkError<T>(val io: IOException) : ResultWrapper<T>()
}