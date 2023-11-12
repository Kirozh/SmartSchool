package com.kirozh.smartschool.data.repository

import com.kirozh.smartschool.data.database.SchoolDao
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.domain.repository.StudentRepository

class StudentRepositoryImpl(
    private val schoolDao: SchoolDao
) : StudentRepository {

    override fun getStudent(studentId: Int): Student? =
        schoolDao.getStudent(studentId)

    override fun getStudentByLogin(login: String): Student? =
        schoolDao.getStudentByLogin(login)

}