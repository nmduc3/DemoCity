package com.example.democity.common

import androidx.lifecycle.Observer

/**
 * Created by nmduc3 on 3/30/21
 */
class Event<T>(private val value: T?) {
    var isHandled: Boolean = false
        private set

    val notHandledContent: T?
        get() {
            return if (isHandled) {
                null
            } else {
                isHandled = true
                value
            }
        }

    val content: T? = value
}

class EventObserver<T>(private val handle: (T?) -> Unit) : Observer<Event<T>> {
    override fun onChanged(e: Event<T>?) {
        if (e != null && e.content == null && !e.isHandled) {
            handle(null)
        } else e?.notHandledContent?.let(handle)
    }
}
