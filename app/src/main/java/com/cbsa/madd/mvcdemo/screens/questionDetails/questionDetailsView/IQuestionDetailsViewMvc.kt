package com.cbsa.madd.mvcdemo.screens.questionDetails.questionDetailsView

import com.cbsa.madd.mvcdemo.networking.MockAPISchemaItem
import com.cbsa.madd.mvcdemo.screens.common.views.IViewMvc

interface IQuestionDetailsViewMvc:
    IViewMvc {

    fun bindQuestionDetails(questionDetails: MockAPISchemaItem)

    fun showProgressIndication()

    fun hideProgressIndication()

}