package com.cbsa.madd.mvcdemo.screens.common.views

import android.content.Context
import android.view.View

abstract class BaseViewMvc: IViewMvc {

    private lateinit var mRootView: View

    override fun getRootView(): View {
        return mRootView
    }

    protected fun getContext(): Context {
        return getRootView().context
    }

    protected fun setRootView(rootView: View) {
        mRootView = rootView
    }
}