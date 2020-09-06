package com.example.droid_github_app.service.repository

import com.example.droid_github_app.service.model.Project
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HTTPS_API_GITHUB_URL = "https://api.github.com/"

class ProjectRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl(HTTPS_API_GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var githubService: GithubService = retrofit.create(GithubService::class.java)

    suspend fun getProjectList(userId: String): Response<List<Project>> = githubService.getProject
    suspend fun getProjectDetails(userID: String, projectName: String): Response<Project> = githubService.getProjectDetails(userID, projectName)

    companion object Factory {
        val instance: ProjectRepository
            @Synchronized get() {
                return ProjectRepository()
            }
    }
}