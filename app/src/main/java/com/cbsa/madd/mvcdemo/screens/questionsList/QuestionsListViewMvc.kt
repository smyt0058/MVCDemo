package com.cbsa.madd.mvcdemo.screens.questionsList

import android.view.View
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem

interface QuestionsListViewMvc {
    interface Listener {
        fun onQuestionClicked(question: MockAPISchemaItem)
    }

    fun registerListener(listener: QuestionsListViewMvc.Listener)
    fun unregisterListener (listener: QuestionsListViewMvc.Listener)
    fun getRootView(): View
    fun bindQuestions(questionArray: MockAPISchema)
}