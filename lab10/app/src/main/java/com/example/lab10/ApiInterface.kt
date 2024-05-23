package com.example.lab10

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/todos/1")
    suspend fun getTodos() : Response<ResponseTodos>

    @POST("/todos/")
    suspend fun addTodo(@Body todo: Todo) : Response<AddTodoResponse>
}