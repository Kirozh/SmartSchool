package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.data.models.Student

interface StudentRepository {

    fun getStudent(studentId: Int): Student?

    fun getStudentByLogin(login: String): Student?
}