package com.example.democity.extension

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by nmduc3 on 3/30/21
 */
fun ViewGroup.inflate(id: Int) = LayoutInflater.from(context).inflate(id, this, false)
