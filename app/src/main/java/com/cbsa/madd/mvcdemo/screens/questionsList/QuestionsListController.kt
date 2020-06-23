package com.cbsa.madd.mvcdemo.screens.questionsList

import android.util.Log
import com.cbsa.madd.mvcdemo.questions.FetchQuestionsListUseCase
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.toastsHelper.ToastHelper
import com.cbsa.madd.mvcdemo.screens.common.screensNavigator.ScreensNavigator

class QuestionsListController(private val mToastHelper: ToastHelper, private val mScreensNavigator: ScreensNavigator, private val mFetchQuestionsListUseCase: FetchQuestionsListUseCase) : IQuestionsListViewMvc.Listener, FetchQuestionsListUseCase.Listener {

    private lateinit var mViewMvc: IQuestionsListViewMvc

    fun bindView(viewMvc: IQuestionsListViewMvc) {
        mViewMvc = viewMvc
    }

    fun onStart() {
        mViewMvc.registerListener(this)
        mFetchQuestionsListUseCase.registerListener(this)
        mFetchQuestionsListUseCase.fetchQuestionsListAndNotify()
    }

    fun onStop() {
        mViewMvc.unregisterListener(this)
        mFetchQuestionsListUseCase.unregisterListener(this)
    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {

        //unregister Listener because of bug where corner cases might make this fire when it's not meant to
        //QuestionDetailsActivity().start(this, question.id)
        mScreensNavigator.navigateToDetailsPage(question.id)
    }

    override fun onQuestionsListFetched(questions: MockAPISchema) {
        mViewMvc.bindQuestions(questions)
    }

    override fun onQuestionsListFetchFailed(error: Throwable?) {
        Log.i("QuestionsListActivity", error.toString())
        mToastHelper.showUseCaseError()
    }

}