package com.cbsa.madd.mvcdemo.screens.questionsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem

class QuestionsListViewMvcImpl(private val inflater: LayoutInflater, private val parent: ViewGroup?) :
    OnQuestionClickListener, QuestionsListViewMvc {

    private var mListeners: ArrayList<QuestionsListViewMvc.Listener> = ArrayList()

    private val mRootView: View = inflater.inflate(R.layout.activity_main, parent, false)

    private val listView: ListView = getRootView().findViewById(R.id.recipe_list_view)

    private val mQuestionsListAdapter = QuestionsListAdapter(getContext(), this)

    init {
        listView.adapter = mQuestionsListAdapter
    }

    override fun registerListener(listener: QuestionsListViewMvc.Listener) {
        mListeners.add(listener)
    }

    override fun unregisterListener (listener: QuestionsListViewMvc.Listener) {
        mListeners.remove(listener)
    }

    override fun getRootView(): View {
        return mRootView
    }

    fun getContext(): Context {
        return getRootView().context
    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        mListeners.forEach {
            it.onQuestionClicked(question)
        }
    }

    override fun bindQuestions(questionArray: MockAPISchema) {

        mQuestionsListAdapter.clear()
        mQuestionsListAdapter.addAll(questionArray)
        mQuestionsListAdapter.notifyDataSetChanged()

    }

}