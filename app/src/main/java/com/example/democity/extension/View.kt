package com.example.democity.extension

import android.os.SystemClock
import android.view.View


fun View.disableMultipleClick(
    timeDelay: Long = 1500,
    eventClick: (view: View) -> Unit
) {
    var timeNow = 0L
    setOnClickListener {
        SystemClock.elapsedRealtime().run {
            if (this - timeNow < timeDelay) {
                return@setOnClickListener
            }
            eventClick.invoke(it)
            timeNow = this
        }
    }
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.showIf(predicate: Boolean) {
    if (predicate) {
        visible()
    } else {
        gone()
    }
}
