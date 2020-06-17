package com.cbsa.madd.mvcdemo.screens.questionsList.questionListView

import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.IObservableViewMvc

interface IQuestionsListViewMvc : IObservableViewMvc<IQuestionsListViewMvc.Listener> {
    interface Listener {
        fun onQuestionClicked(question: MockAPISchemaItem)
    }
    fun bindQuestions(questionArray: MockAPISchema)
}