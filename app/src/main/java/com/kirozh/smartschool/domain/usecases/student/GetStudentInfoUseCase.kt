package com.kirozh.smartschool.domain.usecases.student

import com.kirozh.smartschool.data.common.Resource
import com.kirozh.smartschool.data.remote.dto.toStudent
import com.kirozh.smartschool.domain.models.Student
import com.kirozh.smartschool.domain.repository.StudentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetStudentInfoUseCase(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Student>> = flow {
        runCatching {
            emit(Resource.Loading())
            val student = studentRepository.getStudent(id)?.toStudent()
            emit(Resource.Success(student))
        }.onFailure {
            emit(Resource.Error(message = it.localizedMessage))
        }
    }

}