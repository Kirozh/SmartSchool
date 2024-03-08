package com.kirozh.smartschool

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.kirozh.smartschool.data.remote.SmartSchoolApi
import com.kirozh.smartschool.presentation.viewModels.StudentViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<StudentViewModel>()
    private val api by inject<SmartSchoolApi>() // пример
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}