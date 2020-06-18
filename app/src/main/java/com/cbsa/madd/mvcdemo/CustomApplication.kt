package com.cbsa.madd.mvcdemo

import android.app.Application
import com.cbsa.madd.mvcdemo.common.dependencyInjection.CompositionRoot

class CustomApplication : Application() {

    private val mCompositionRoot: CompositionRoot = CompositionRoot()

    fun getCompositionRoot(): CompositionRoot {
        return mCompositionRoot
    }

}