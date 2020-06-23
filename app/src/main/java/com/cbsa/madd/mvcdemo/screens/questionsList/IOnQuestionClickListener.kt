package com.cbsa.madd.mvcdemo.screens.questionsList

import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem

interface IOnQuestionClickListener {

    fun onQuestionClicked(question: MockAPISchemaItem)

}