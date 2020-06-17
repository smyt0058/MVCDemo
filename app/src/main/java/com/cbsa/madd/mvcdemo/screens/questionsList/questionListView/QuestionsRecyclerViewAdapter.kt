package com.cbsa.madd.mvcdemo.screens.questionsList.questionListView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.IQuestionsListItemMvc
import com.cbsa.madd.mvcdemo.screens.questionsList.questionListItem.QuestionsListItemMvcImpl

class QuestionsRecyclerViewAdapter(private val context: Context, onQuestionClickListener: IOnQuestionClickListener) : RecyclerView.Adapter<QuestionsRecyclerViewAdapter.MyViewHolder>(),
    IQuestionsListItemMvc.Listener {

    private val mOnQuestionClickListener = onQuestionClickListener

    private var mDataSource = arrayListOf<MockAPISchemaItem>()

    class MyViewHolder(viewMvc: IQuestionsListItemMvc) :
        ViewHolder(viewMvc.getRootView()) {
        val mViewMvc: IQuestionsListItemMvc = viewMvc
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        Log.i("QuestionsRecyclerViewAdapter", "onQuestionClicked clicked")
        mOnQuestionClickListener.onQuestionClicked(question)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewItemMvcImpl =
            QuestionsListItemMvcImpl(
                LayoutInflater.from(context),
                parent
            )
        viewItemMvcImpl.registerListener(this)
        return MyViewHolder(
            viewItemMvcImpl
        )
    }

    override fun getItemCount(): Int {
        return mDataSource.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mViewMvc.bindQuestion(mDataSource[position])
    }

    fun bindQuestions(questionArray: MockAPISchema) {
        mDataSource = questionArray
        notifyDataSetChanged()
    }
}