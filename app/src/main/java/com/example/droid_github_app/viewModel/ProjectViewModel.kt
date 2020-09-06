package com.example.droid_github_app.viewModel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.droid_github_app.service.model.Project
import com.example.droid_github_app.service.repository.ProjectRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProjectViewModel(
    private val myApplication: Application,
    private val myProjectID: String
) : AndroidViewModel(myApplication) {

    private val repository = ProjectRepository.instance
    val projectLiveData: MutableLiveData<Project> = MutableLiveData()

    var project = ObservableField<Project>()

    init {
        loadProject()
    }

    private fun loadProject() = viewModelScope.launch {
        try {
            val project = repository.getProjectDetails("amaocha-first", myProjectID)
            if (project.isSuccessful) {
                projectLiveData.postValue(project.body())
            }
        } catch (e: Exception) {
            Log.e("loadProject:Failed", e.stackTrace.toString())
        }
    }

    fun setProject(project: Project) {
        this.project.set(project)
    }

    class Factory(private val application: Application, private val projectID: String) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProjectViewModel(application, projectID) as T
        }
    }
}