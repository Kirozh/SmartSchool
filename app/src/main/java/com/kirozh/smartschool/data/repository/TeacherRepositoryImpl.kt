package com.kirozh.smartschool.data.repository

import com.kirozh.smartschool.data.database.SchoolDao
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.data.models.Teacher
import com.kirozh.smartschool.domain.repository.StudentRepository
import com.kirozh.smartschool.domain.repository.TeacherRepository

class TeacherRepositoryImpl(
    private val schoolDao: SchoolDao
) : TeacherRepository {

    override fun getTeacher(teacherId: Int): Teacher? =
        schoolDao.getTeacher(teacherId)

    override fun getTeacherByLogin(login: String): Teacher? =
        schoolDao.getTeacherByLogin(login)

}