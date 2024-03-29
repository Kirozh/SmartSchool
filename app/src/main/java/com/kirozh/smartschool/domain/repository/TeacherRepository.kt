package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.domain.models.Teacher

interface TeacherRepository {

    fun getTeacher(teacherId: Int): Teacher?

    fun getTeacherByLogin(login: String): Teacher?
}