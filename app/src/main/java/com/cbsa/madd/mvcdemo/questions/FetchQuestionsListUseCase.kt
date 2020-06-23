package com.cbsa.madd.mvcdemo.questions

import com.cbsa.madd.mvcdemo.common.BaseObservable
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.networking.MockAPISchema
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FetchQuestionsListUseCase(private val mMockAPI: MockAPI): BaseObservable<FetchQuestionsListUseCase.Listener>() {

    interface Listener {
        fun onQuestionsListFetched(questions: MockAPISchema)
        fun onQuestionsListFetchFailed(error: Throwable?)
    }

    fun fetchQuestionsListAndNotify() {
        mMockAPI.getQuestions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> notifySuccess(result) },
                { error -> notifyFailure(error) }
            )
    }

    private fun notifyFailure(error: Throwable?) {
        getListeners().forEach {
            it.onQuestionsListFetchFailed(error)
        }
    }

    private fun notifySuccess(questions: MockAPISchema) {

        getListeners().forEach {
            it.onQuestionsListFetched(questions)
        }

    }

}