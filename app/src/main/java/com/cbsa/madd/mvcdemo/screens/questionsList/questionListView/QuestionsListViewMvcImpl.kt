package com.cbsa.madd.mvcdemo.screens.questionsList.questionListView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.BaseObservableViewMvc
import com.cbsa.madd.mvcdemo.screens.common.ViewMvcFactory

class QuestionsListViewMvcImpl(
    private val inflater: LayoutInflater,
    private val parent: ViewGroup?,
    private val viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<IQuestionsListViewMvc.Listener>(),
    IOnQuestionClickListener,
    IQuestionsListViewMvc {

    init {
        setRootView(inflater.inflate(R.layout.activity_main, parent, false))
    }

    private val recyclerView: RecyclerView = getRootView().findViewById(R.id.recipe_list_view)

    private val mQuestionsListAdapter =
        QuestionsRecyclerViewAdapter(
            this, viewMvcFactory
        )

    init {
        recyclerView.adapter = mQuestionsListAdapter
        recyclerView.layoutManager = LinearLayoutManager(getContext())
    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        getListeners().forEach {
            it.onQuestionClicked(question)
        }
    }

    override fun bindQuestions(questionArray: MockAPISchema) {

        mQuestionsListAdapter.bindQuestions(questionArray)

    }

}