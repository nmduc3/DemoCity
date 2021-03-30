package com.example.democity.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.democity.data.response.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by nmduc3 on 3/29/21
 */

fun <V : ViewBinding> fragmentInflate(params: (LayoutInflater, ViewGroup?, Boolean) -> V?) = params

fun <V : ViewBinding> activityInflate(params: (LayoutInflater) -> V?) = params

suspend fun <R> callApi(
    callFunction: suspend () -> R
): ResultWrapper<R> {
    return withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(callFunction())
        } catch (e: IOException) {
            ResultWrapper.NetworkError(e)
        } catch (e: HttpException) {
            ResultWrapper.GenericError(e.code(), e.message())
        }
    }
}
