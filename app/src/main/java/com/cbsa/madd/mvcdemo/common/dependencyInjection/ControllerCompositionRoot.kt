package com.cbsa.madd.mvcdemo.common.dependencyInjection

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.screens.common.ViewMvcFactory

class ControllerCompositionRoot(val mCompositionRoot: CompositionRoot, val mActivity: Activity) {

    //private val mCompositionRoot = compositionRoot

    fun getMockApi(context: Context): MockAPI { return mCompositionRoot.getMockApi(context) }

    fun getLayoutInflater(): LayoutInflater { return LayoutInflater.from(mActivity) }

    fun getViewMvcFactory(): ViewMvcFactory { return  ViewMvcFactory(getLayoutInflater())
    }

}