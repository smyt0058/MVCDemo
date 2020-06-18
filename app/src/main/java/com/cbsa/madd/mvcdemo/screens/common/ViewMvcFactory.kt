package com.cbsa.madd.mvcdemo.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.IQuestionsListItemMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.QuestionsListItemMvcImpl
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListView.IQuestionsListViewMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListView.QuestionsListViewMvcImpl

class ViewMvcFactory(val mLayoutInflater: LayoutInflater) {

    fun getQuestionsListViewMvc(parent: ViewGroup?): IQuestionsListViewMvc {
        return QuestionsListViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getQuestionsListItemMvc(parent: ViewGroup?): IQuestionsListItemMvc {
        return QuestionsListItemMvcImpl(mLayoutInflater, parent)
    }

}