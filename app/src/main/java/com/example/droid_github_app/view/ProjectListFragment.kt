package com.example.droid_github_app.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.droid_github_app.viewModel.ProjectListViewModel

const val TAG_OF_PROJECT_LIST_FRAGMENT = "ProjectListFragment"

class ProjectListFragment : Fragment() {
    private val viewModel  = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)

    private lateinit var dataBinding: FragmentProjectListBinding
    private lateinit var projectAdapter: ProjectAdapter
}