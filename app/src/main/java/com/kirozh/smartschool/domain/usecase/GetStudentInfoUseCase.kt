package com.kirozh.smartschool.domain.usecase

import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.domain.repository.StudentRepository

class GetStudentInfoUseCase(
    private val studentRepository: StudentRepository
) {

    fun getStudent(studentId: Int): Student? {
        return studentRepository.getStudent(studentId)
    }

    fun getStudentByLogin(login: String): Student? =
        studentRepository.getStudentByLogin(login)
}