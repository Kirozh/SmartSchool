package com.kirozh.smartschool.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.kirozh.smartschool.domain.usecase.GetStudentInfoUseCase

class StudentViewModel(
    private val studentInfoUseCase: GetStudentInfoUseCase
) : ViewModel() {
}