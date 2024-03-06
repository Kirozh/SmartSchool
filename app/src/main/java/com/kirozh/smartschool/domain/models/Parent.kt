package com.kirozh.smartschool.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Parent(
    @PrimaryKey(autoGenerate = true)
    val parentId: Int,
    val name: String,
    val secondName: String?,
    val surname: String,
    val login: String,
    var password: String,
    val phone: String,
    val studentId: Int,
    val photo: String?
)