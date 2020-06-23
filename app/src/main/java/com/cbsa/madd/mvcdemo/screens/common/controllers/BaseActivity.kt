package com.cbsa.madd.mvcdemo.screens.common.controllers

import androidx.appcompat.app.AppCompatActivity
import com.cbsa.madd.mvcdemo.common.CustomApplication
import com.cbsa.madd.mvcdemo.common.dependencyInjection.ControllerCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val mControllerCompositionRoot by lazy {
        ControllerCompositionRoot(
            CustomApplication().getCompositionRoot(), this)
    }

    protected fun getCompositionRoot(): ControllerCompositionRoot {
        return mControllerCompositionRoot
    }

}