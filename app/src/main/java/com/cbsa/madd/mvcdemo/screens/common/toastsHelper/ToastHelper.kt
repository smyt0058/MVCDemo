package com.cbsa.madd.mvcdemo.screens.common.toastsHelper

import android.content.Context
import android.widget.Toast

class ToastHelper(val mContext: Context) {
    fun showUseCaseError() {
        Toast.makeText(mContext, "Network call failed", Toast.LENGTH_SHORT).show()
    }
}