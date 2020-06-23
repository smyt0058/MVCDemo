package com.cbsa.madd.mvcdemo.common.dependencyInjection

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import com.cbsa.madd.mvcdemo.questions.FetchQuestionDetailsUseCase
import com.cbsa.madd.mvcdemo.questions.FetchQuestionsListUseCase
import com.cbsa.madd.mvcdemo.networking.MockAPI
import com.cbsa.madd.mvcdemo.screens.common.toastsHelper.ToastHelper
import com.cbsa.madd.mvcdemo.screens.common.screensNavigator.ScreensNavigator
import com.cbsa.madd.mvcdemo.screens.common.ViewMvcFactory
import com.cbsa.madd.mvcdemo.screens.questionsList.QuestionsListController

class ControllerCompositionRoot(val mCompositionRoot: CompositionRoot, val mActivity: Activity) {

    //private val mCompositionRoot = compositionRoot

    private fun getMockApi(context: Context): MockAPI { return mCompositionRoot.getMockApi(context) }

    private fun getLayoutInflater(): LayoutInflater { return LayoutInflater.from(mActivity) }

    fun getViewMvcFactory(): ViewMvcFactory { return  ViewMvcFactory(getLayoutInflater())
    }

    fun getFetchQuestionDetailsUseCase(context: Context): FetchQuestionDetailsUseCase { return FetchQuestionDetailsUseCase(
        getMockApi(context)
    )
    }

    fun getFetchQuestionsListUseCase(context: Context): FetchQuestionsListUseCase { return FetchQuestionsListUseCase(
        getMockApi(context)
    )
    }

    fun getQuestionsListController(): QuestionsListController {
        return QuestionsListController(
            getMessagesDisplayer(),
            getScreenNavigator(),
            getFetchQuestionsListUseCase(getContext())
        )
    }

    private fun getContext(): Context {
        return mActivity
    }

    fun getMessagesDisplayer(): ToastHelper { return ToastHelper(
        getContext()
    )
    }

    fun getScreenNavigator(): ScreensNavigator { return ScreensNavigator(
        getContext()
    )
    }

}