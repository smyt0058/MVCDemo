package com.cbsa.madd.mvcdemo.networking


import com.google.gson.annotations.SerializedName

data class MockAPISchemaItem(
    val answer: String,
    val createdAt: String,
    val id: String,
    val question: String
)