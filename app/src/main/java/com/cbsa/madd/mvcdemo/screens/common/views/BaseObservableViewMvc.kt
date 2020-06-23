package com.cbsa.madd.mvcdemo.screens.common.views

import android.util.Log
import java.util.*
import kotlin.collections.HashSet

abstract class BaseObservableViewMvc<ListenerType> : BaseViewMvc(),
    IObservableViewMvc<ListenerType> {

    private var mListeners: Set<ListenerType> = HashSet()

    override fun registerListener(listener: ListenerType) {
        Log.i("BaseObservableViewMvc", listener.toString())
        mListeners = mListeners.plus(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        Log.i("BaseObservableViewMvc", listener.toString())
        mListeners = mListeners.minus(listener)
    }

    protected fun getListeners(): Set<ListenerType> {
        Log.i("BaseObservableViewMvc", mListeners.toString())
        return Collections.unmodifiableSet(mListeners)
    }

}