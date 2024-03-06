package com.kirozh.smartschool.data.remote.dto

import com.kirozh.smartschool.domain.models.Student

data class StudentDto (
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

fun StudentDto.toStudent(): Student =
    Student(
        studentId = this.studentId,
        name = this.name,
        surname = this.surname,
        login = this.login,
        password = this.password,
        classNumberId = this.classNumberId,
        dateOfBirth = this.dateOfBirth,
        photo = this.photo,
        formTeacherId = this.formTeacherId,
    )