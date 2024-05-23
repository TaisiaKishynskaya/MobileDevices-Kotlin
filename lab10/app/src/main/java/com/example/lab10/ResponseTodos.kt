package com.example.lab10

import com.google.gson.annotations.SerializedName

data class ResponseTodos(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("completed")
    var completed: Boolean,
)
