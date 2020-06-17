package com.cbsa.madd.mvcdemo.screens.questionsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListView.IQuestionsListViewMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListView.QuestionsListViewMvcImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class QuestionsListActivity : AppCompatActivity(), IQuestionsListViewMvc.Listener {

    val mockAPI by lazy {
        MockAPI.create(this)
    }
    var disposable: Disposable? = null

    lateinit var mViewMvc: IQuestionsListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewMvc =
            QuestionsListViewMvcImpl(
                LayoutInflater.from(this),
                null
            )
        mViewMvc.registerListener(this)

        setContentView(mViewMvc.getRootView())

    }

    override fun onStart() {
        super.onStart()
        fetchQuestions()

    }

    fun fetchQuestions() {
        disposable =
            mockAPI.getQuestions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> bindQuestions(result) },
                    { error -> Log.i("MainActivity", error.toString()) }
                )
    }

    fun bindQuestions(questionArray: MockAPISchema) {

        mViewMvc.bindQuestions(questionArray)

    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        Toast.makeText(this, question.question, Toast.LENGTH_SHORT).show()
    }


}