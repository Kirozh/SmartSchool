package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student

interface ParentRepository {

    fun getParent(parentId: Int): Parent?

    fun getParentByLogin(login: String): Parent?
}