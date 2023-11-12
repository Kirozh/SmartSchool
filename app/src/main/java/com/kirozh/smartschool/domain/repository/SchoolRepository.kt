package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.data.models.Teacher

interface SchoolRepository {



    fun getParent(parentId: Int): Parent?

    fun getTeacher(teacherId: Int): Teacher?
}