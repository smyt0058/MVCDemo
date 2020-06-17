package com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.BaseObservableViewMvc

class QuestionsListItemMvcImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseObservableViewMvc<IQuestionsListItemMvc.Listener>(),
    IQuestionsListItemMvc {

    init {
        setRootView(inflater.inflate(R.layout.question_list_item, parent, false))
    }

    private var mQuestion: MockAPISchemaItem? = null

    private val mTextTitle: TextView = getRootView().findViewById(R.id.questionTitle)

    init {
        Log.i("QuestionsListItemMvcImpl", "init 2 fired")
        getRootView().setOnClickListener {
            getListeners().forEach {
                Log.i("QuestionListItemMvcImpl", it.toString())
                it.onQuestionClicked(mQuestion!!)
            }
        }
    }

    override fun bindQuestion(question: MockAPISchemaItem) {
        mQuestion = question
        mTextTitle.text = question.question
    }

}