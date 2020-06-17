package com.cbsa.madd.mvcdemo.screens.questionsList.questionListView

import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem

interface IOnQuestionClickListener {

    fun onQuestionClicked(question: MockAPISchemaItem)

}