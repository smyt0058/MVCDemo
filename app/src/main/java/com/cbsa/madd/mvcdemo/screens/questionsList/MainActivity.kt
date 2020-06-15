package com.cbsa.madd.mvcdemo.screens.questionsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.cbsa.madd.mvcdemo.R
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnQuestionClickListener  {

    val mockAPI by lazy {
        MockAPI.create(this)
    }
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

        var listItems = arrayOfNulls<String>(questionArray.size)

        for (i in 0 until questionArray.size) {
            val question = questionArray[i]
            listItems[i] = question.question
        }

        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        val adapter = QuestionsListAdapter(this, questionArray, this)
        recipe_list_view.adapter = adapter

    }

    override fun onQuestionClicked(question: MockAPISchemaItem) {
        Toast.makeText(this, question.question, Toast.LENGTH_SHORT).show()
    }


}