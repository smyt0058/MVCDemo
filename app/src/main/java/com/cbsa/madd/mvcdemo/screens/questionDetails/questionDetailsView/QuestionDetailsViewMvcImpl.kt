package com.cbsa.madd.mvcdemo.screens.questionDetails.questionDetailsView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.views.BaseViewMvc

class QuestionDetailsViewMvcImpl(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseViewMvc(), IQuestionDetailsViewMvc {

    private val loadingIndicator by lazy {
        getRootView().findViewById<TextView>(R.id.loadingIndicator)
    }

    private val questionDetailLayout by lazy {
        getRootView().findViewById<RelativeLayout>(R.id.questionDetailLayout)
    }

    private val questionIdTv by lazy {
        getRootView().findViewById<TextView>(R.id.questionId)
    }
    private val questionCreatedAtTv by lazy {
        getRootView().findViewById<TextView>(R.id.questionCreatedAt)
    }
    private val questionAnswerTv by lazy {
        getRootView().findViewById<TextView>(R.id.questionAnswer)
    }

    private val questionTitleTv by lazy {
        getRootView().findViewById<TextView>(R.id.questionTitle)
    }

    init {
        setRootView(inflater.inflate(R.layout.activity_question_details, parent, false))
    }

    override fun bindQuestionDetails(questionDetails: MockAPISchemaItem) {

        questionTitleTv.text = questionDetails.question
        questionIdTv.text = questionDetails.id
        questionCreatedAtTv.text = questionDetails.createdAt
        questionAnswerTv.text = questionDetails.answer

    }

    override fun showProgressIndication() {
        loadingIndicator.visibility = View.VISIBLE
        questionDetailLayout.visibility = View.GONE

    }

    override fun hideProgressIndication() {
        loadingIndicator.visibility = View.GONE
        questionDetailLayout.visibility = View.VISIBLE
    }


}