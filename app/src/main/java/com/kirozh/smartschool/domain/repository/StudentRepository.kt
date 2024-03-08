package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.data.remote.dto.StudentDto

interface StudentRepository {

    suspend fun getStudent(studentId: Int): StudentDto?
}