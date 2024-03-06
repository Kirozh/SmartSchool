package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.domain.models.Parent
import com.kirozh.smartschool.domain.models.Teacher

interface SchoolRepository {

    fun getParent(parentId: Int): Parent?

    fun getTeacher(teacherId: Int): Teacher?
}