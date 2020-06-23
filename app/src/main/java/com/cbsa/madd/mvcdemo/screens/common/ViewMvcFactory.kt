package com.cbsa.madd.mvcdemo.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cbsa.madd.mvcdemo.screens.common.toolbar.ToolbarViewMvc
import com.cbsa.madd.mvcdemo.screens.questionDetails.questionDetailsView.IQuestionDetailsViewMvc
import com.cbsa.madd.mvcdemo.screens.questionDetails.questionDetailsView.QuestionDetailsViewMvcImpl
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.IQuestionsListItemMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.QuestionsListItemMvcImpl
import com.cbsa.madd.mvcdemo.screens.questionsList.IQuestionsListViewMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.QuestionsListViewMvcImpl

class ViewMvcFactory(val mLayoutInflater: LayoutInflater) {

    fun getQuestionsListViewMvc(parent: ViewGroup?): IQuestionsListViewMvc {
        return QuestionsListViewMvcImpl(
            mLayoutInflater,
            parent,
            this
        )
    }

    fun getQuestionsListItemMvc(parent: ViewGroup?): IQuestionsListItemMvc {
        return QuestionsListItemMvcImpl(mLayoutInflater, parent)
    }

    fun getQuestionsDetailsViewMvc(parent: ViewGroup?): IQuestionDetailsViewMvc {
        return QuestionDetailsViewMvcImpl(mLayoutInflater, parent)
    }

    fun getToolbarViewMvc(parent: ViewGroup?): ToolbarViewMvc {
        return ToolbarViewMvc(mLayoutInflater, parent)
    }

}