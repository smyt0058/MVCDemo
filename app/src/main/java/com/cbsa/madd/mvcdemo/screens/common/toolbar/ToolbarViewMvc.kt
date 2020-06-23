package com.cbsa.madd.mvcdemo.screens.common.toolbar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.screens.common.views.BaseViewMvc
import kotlinx.android.synthetic.main.my_toolbar.view.*

class  ToolbarViewMvc(private val inflater: LayoutInflater, private val parent:  ViewGroup?): BaseViewMvc() {



    init {
        setRootView(inflater.inflate(R.layout.my_toolbar,  parent, false))
        //mToolbar= getRootView().findViewById(R.id.my_toolbar)
    }

    private var mToolbarTitle: TextView = getRootView().findViewById(R.id.my_toolbar_title)

    fun setTitle(title: String) {
        Log.i("ToolbarViewMvc", title)
        mToolbarTitle.text = title
    }



}