package com.example.droid_github_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.droid_github_app.service.model.Project
import com.example.droid_github_app.service.repository.ProjectRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProjectListViewModel: ViewModel() {
    private val repository = ProjectRepository.instance

    var projectListLiveData: MutableLiveData<List<Project>> = MutableLiveData()

    init {
        loadProjectList()
    }

    private fun loadProjectList() {
        viewModelScope.launch {
            try {
                val response = repository.getProjectList("amaocha-first")
                if (response.isSuccessful) {
                    projectListLiveData.postValue(response.body())
                }
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }
}