package com.cbsa.madd.mvcdemo.screens.common.screensNavigator

import android.content.Context
import com.cbsa.madd.mvcdemo.screens.questionDetails.QuestionDetailsActivity

class ScreensNavigator(private val mContext: Context) {

    fun navigateToDetailsPage(questionId: String) {
        QuestionDetailsActivity().start(mContext, questionId)
    }


}