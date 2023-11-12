package com.kirozh.smartschool.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId: Int,
    val name: String,
    val surname: String,
    val login: String,
    var password: String,
    /** 11A */
    val classNumberId: Int,
    val dateOfBirth: String,
    val photo: String,
    /** Классный руководитель*/
    val formTeacherId: Int?,
)
