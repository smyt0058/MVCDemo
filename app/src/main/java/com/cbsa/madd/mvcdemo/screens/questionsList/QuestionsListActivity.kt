package com.cbsa.madd.mvcdemo.screens.questionsList

import android.os.Bundle
import com.cbsa.madd.mvcdemo.questions.FetchQuestionsListUseCase
import com.cbsa.madd.mvcdemo.screens.common.controllers.BaseActivity

class QuestionsListActivity : BaseActivity() {

    private val mFetchQuestionsListUseCase: FetchQuestionsListUseCase = getCompositionRoot().getFetchQuestionsListUseCase(this)

    private val mQuestionsListController: QuestionsListController = getCompositionRoot().getQuestionsListController()

    //private lateinit var mViewMvc: IQuestionsListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null)
        //mViewMvc.registerListener(this)
        mQuestionsListController.bindView(mViewMvc)

        setContentView(mViewMvc.getRootView())

    }

    override fun onStart() {
        super.onStart()
        mQuestionsListController.onStart()
//        mFetchQuestionsListUseCase.registerListener(this)
//        mFetchQuestionsListUseCase.fetchQuestionsListAndNotify()
    }

    override fun onStop() {
        super.onStop()
        mQuestionsListController.onStop()
        //mFetchQuestionsListUseCase.unregisterListener(this)
    }

//    private fun bindQuestions(questionArray: MockAPISchema) {
//
//        mViewMvc.bindQuestions(questionArray)
//
//    }

//    override fun onQuestionClicked(question: MockAPISchemaItem) {
////        Toast.makeText(this, question.question, Toast.LENGTH_SHORT).show()
//        QuestionDetailsActivity().start(this, question.id)
//    }
//
//    override fun onQuestionsListFetched(questions: MockAPISchema) {
//        mViewMvc.bindQuestions(questions)
//    }
//
//    override fun onQuestionsListFetchFailed(error: Throwable?) {
//        Log.i("QuestionsListActivity", error.toString())
//    }


}