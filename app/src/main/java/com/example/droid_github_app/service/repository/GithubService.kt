package com.example.droid_github_app.service.repository

import com.example.droid_github_app.service.model.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    //一覧
    @GET("users/{user}/repos")
    suspend fun getProjectList(@Path("user") user: String): Response<List<Project>>

    @GET("/repos/{user}/{reponame}")
    suspend fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Response<Project>
}