package com.kirozh.smartschool.presentation.viewModels

import com.kirozh.smartschool.domain.models.Student

data class StudentState(
    val isLoading: Boolean = false,
    val student: Student? = null,
    val errorMessage: String = "",
)
