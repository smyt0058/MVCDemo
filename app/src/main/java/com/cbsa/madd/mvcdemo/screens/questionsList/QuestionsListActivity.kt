package com.cbsa.madd.mvcdemo.screens.questionsList

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.BaseActivity
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListView.IQuestionsListViewMvc
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class QuestionsListActivity : BaseActivity(), IQuestionsListViewMvc.Listener {

    private val mockAPI by lazy {
        getCompositionRoot().getMockApi(this)
    }
    private var disposable: Disposable? = null

    private lateinit var mViewMvc: IQuestionsListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null)
        mViewMvc.registerListener(this)

        setContentView(mViewMvc.getRootView())

    }

    override fun onStart() {
        super.onStart()
        fetchQuestions()

    }

    private fun fetchQuestions() {
        disposable =
            mockAPI.getQuestions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> bindQuestions(result) },
                    { error -> Log.i("MainActivity", error.toString()) }
                )
    }

    private fun bindQuestions(questionArray: MockAPISchema) {

        mViewMvc.bindQuestions(questionArray)

    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        Toast.makeText(this, question.question, Toast.LENGTH_SHORT).show()
    }


}