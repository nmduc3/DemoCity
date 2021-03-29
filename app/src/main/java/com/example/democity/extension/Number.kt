package com.example.democity.extension

import android.content.res.Resources

fun Int.toPx(): Float = (this * Resources.getSystem().displayMetrics.density)

