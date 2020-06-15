package com.cbsa.madd.mvcdemo.screens.questionsList

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import kotlinx.android.synthetic.main.question_list_item.view.*

class QuestionsListAdapter(private val context: Context, private val dataSource: MockAPISchema, onQuestionClickListener: OnQuestionClickListener) : BaseAdapter() {

    val onQuestionClickListener = onQuestionClickListener

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.question_list_item, parent, false)

        val question: MockAPISchemaItem = getItem(position)

        Log.i("QuestionsListAdapter", question.question)

        rowView.questionTitle.text = question.question
        rowView.setOnClickListener {
            onQuestionClickListener.onQuestionClicked(question)
        }

        return rowView
    }

    override fun getItem(position: Int): MockAPISchemaItem {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}