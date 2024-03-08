package com.kirozh.smartschool.domain.repository

import com.kirozh.smartschool.domain.models.Parent

interface ParentRepository {

    fun getParent(parentId: Int): Parent?

    fun getParentByLogin(login: String): Parent?
}