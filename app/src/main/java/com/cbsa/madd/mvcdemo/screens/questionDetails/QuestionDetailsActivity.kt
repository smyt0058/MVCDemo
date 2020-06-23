package com.cbsa.madd.mvcdemo.screens.questionDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.cbsa.madd.mvcdemo.questions.FetchQuestionDetailsUseCase
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.controllers.BaseActivity
import com.cbsa.madd.mvcdemo.screens.common.toastsHelper.ToastHelper

class QuestionDetailsActivity : BaseActivity(), FetchQuestionDetailsUseCase.Listener {

    val EXTRA_QUESTION_ID: String = "EXTRA_QUESTION_ID"

    private val mFetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase = getCompositionRoot().getFetchQuestionDetailsUseCase(this)

    private val mToastHelper: ToastHelper = getCompositionRoot().getMessagesDisplayer()

    private val mViewMvc by lazy {
        getCompositionRoot().getViewMvcFactory().getQuestionsDetailsViewMvc(null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewMvc.getRootView())
    }

    fun start(context: Context, questionId: String) {
        val intent = Intent(context, QuestionDetailsActivity::class.java)
        intent.putExtra(EXTRA_QUESTION_ID, questionId)
        context.startActivity(intent)

    }

    override fun onStart() {
        super.onStart()
        mViewMvc.showProgressIndication()
        mFetchQuestionDetailsUseCase.registerListener(this)
        getQuestionId()?.let { mFetchQuestionDetailsUseCase.fetchQuestionDetailsAndNotify(it) }
        //fetchQuestionDetails()

    }

    override fun onStop() {
        super.onStop()
        mFetchQuestionDetailsUseCase.unregisterListener(this)

    }

    private fun getQuestionId(): String? {
        return intent.getStringExtra(EXTRA_QUESTION_ID)
    }

    override fun onQuestionDetailsFetched(questionDetails: MockAPISchemaItem) {
        Log.i("QuestionDetailsActivity", questionDetails.toString())
        mViewMvc.hideProgressIndication()
        mViewMvc.bindQuestionDetails(questionDetails)
    }

    override fun onQuestionDetailsFetchFailed(error: Throwable?) {
        mViewMvc.hideProgressIndication()
        //Toast.makeText(this, "Network Call Failed", Toast.LENGTH_SHORT).show()
        mToastHelper.showUseCaseError()
        Log.i("MainActivity", error.toString())
    }

}