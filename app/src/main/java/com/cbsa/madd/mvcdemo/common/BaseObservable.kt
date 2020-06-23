package com.cbsa.madd.mvcdemo.common

import android.util.Log
import java.util.*
import kotlin.collections.HashSet

abstract class BaseObservable<ListenerType> {

    private var mListeners: Set<ListenerType> = HashSet()

    fun registerListener(listener: ListenerType) {
        Log.i("BaseObservableViewMvc", listener.toString())
        mListeners = mListeners.plus(listener)
    }

    fun unregisterListener(listener: ListenerType) {
        Log.i("BaseObservableViewMvc", listener.toString())
        mListeners = mListeners.minus(listener)
    }

    protected fun getListeners(): Set<ListenerType> {
        Log.i("BaseObservableViewMvc", mListeners.toString())
        return Collections.unmodifiableSet(mListeners)
    }

}