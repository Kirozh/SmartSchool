package com.kirozh.smartschool.presentation.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kirozh.smartschool.data.common.Resource
import com.kirozh.smartschool.domain.usecases.student.GetStudentInfoUseCase
import kotlinx.coroutines.flow.onEach

class StudentViewModel(
    private val studentInfoUseCase: GetStudentInfoUseCase,
//    private val savedStateHandle: SavedStateHandle,
    id: Int = 0,
) : ViewModel() {

    private val _state: MutableState<StudentState> = mutableStateOf(StudentState())
    val state: State<StudentState> = _state

    init {
        getStudent(id)
    }
    private fun getStudent(id: Int) {
        studentInfoUseCase.invoke(id).onEach {
            when(it) {
                is Resource.Loading -> { _state.value = StudentState(isLoading = true) }
                is Resource.Error -> { _state.value = StudentState(errorMessage = it.message ?: "") }
                is Resource.Success -> { _state.value = StudentState(student = it.data) }
            }
        }
    }
}