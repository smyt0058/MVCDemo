package com.cbsa.madd.mvcdemo.questions

import com.cbsa.madd.mvcdemo.common.BaseObservable
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FetchQuestionDetailsUseCase(private val mMockAPI: MockAPI): BaseObservable<FetchQuestionDetailsUseCase.Listener>() {

    interface Listener {
        fun onQuestionDetailsFetched(questionDetails: MockAPISchemaItem)
        fun onQuestionDetailsFetchFailed(error: Throwable?)
    }

    fun fetchQuestionDetailsAndNotify(questionId: String) {
        mMockAPI.getQuestionDetails(questionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> notifySuccess(result) },
                { error -> notifyFailure(error) }
            )
    }

    private fun notifyFailure(error: Throwable?) {
        getListeners().forEach {
            it.onQuestionDetailsFetchFailed(error)
        }
    }

    private fun notifySuccess(questionDetails: MockAPISchemaItem) {

        getListeners().forEach {
            it.onQuestionDetailsFetched(questionDetails)
        }

    }

}