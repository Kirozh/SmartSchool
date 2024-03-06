package com.kirozh.smartschool.data.repository

import com.kirozh.smartschool.data.remote.dto.StudentDto
import com.kirozh.smartschool.domain.repository.StudentRepository

// TODO add SmartSchoolApi
class StudentRepositoryImpl : StudentRepository {

    override suspend fun getStudent(studentId: Int): StudentDto? = TODO()

}