package com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem

import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.IObservableViewMvc

interface IQuestionsListItemMvc : IObservableViewMvc<IQuestionsListItemMvc.Listener> {

    interface Listener {
        fun onQuestionClicked(question: MockAPISchemaItem)
    }
    fun bindQuestion(question: MockAPISchemaItem)

}