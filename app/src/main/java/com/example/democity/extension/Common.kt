package com.example.democity.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


/**
 * Created by nmduc3 on 3/29/21
 */

fun <V : ViewBinding> fragmentInflate(params: (LayoutInflater, ViewGroup?, Boolean) -> V?) = params

fun <V : ViewBinding> activityInflate(params: (LayoutInflater) -> V?) = params
