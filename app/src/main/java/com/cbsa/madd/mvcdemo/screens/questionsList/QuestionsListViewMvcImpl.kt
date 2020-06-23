package com.cbsa.madd.mvcdemo.screens.questionsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.views.BaseObservableViewMvc
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

    private val mRecyclerView: RecyclerView = getRootView().findViewById(R.id.recipe_list_view)
    private val mToolBar: Toolbar = getRootView().findViewById(R.id.my_toolbar)
    private val mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolBar)

    private val mQuestionsListAdapter =
        QuestionsRecyclerViewAdapter(
            this, viewMvcFactory
        )

    init {
        mRecyclerView.adapter = mQuestionsListAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(getContext())
        mToolbarViewMvc.setTitle("Questions List")
        mToolBar.addView(mToolbarViewMvc.getRootView())
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