package com.kirozh.smartschool.data.repository

import com.kirozh.smartschool.data.database.SchoolDao
import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.data.models.Teacher
import com.kirozh.smartschool.domain.repository.SchoolRepository

class SchoolRepositoryImpl(
    private val schoolDao: SchoolDao
) : SchoolRepository {

    override fun getParent(parentId: Int): Parent? =
        schoolDao.getParent(parentId)

    override fun getTeacher(teacherId: Int): Teacher? =
        schoolDao.getTeacher(teacherId)

}