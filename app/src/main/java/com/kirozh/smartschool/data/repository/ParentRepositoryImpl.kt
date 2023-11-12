package com.kirozh.smartschool.data.repository

import com.kirozh.smartschool.data.database.SchoolDao
import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.domain.repository.ParentRepository
import com.kirozh.smartschool.domain.repository.StudentRepository

class ParentRepositoryImpl(
    private val schoolDao: SchoolDao
) : ParentRepository {

    override fun getParent(parentId: Int): Parent? =
        schoolDao.getParent(parentId)

    override fun getParentByLogin(login: String): Parent? =
        schoolDao.getParentByLogin(login)

}