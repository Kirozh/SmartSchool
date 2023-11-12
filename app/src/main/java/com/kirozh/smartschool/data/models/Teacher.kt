package com.kirozh.smartschool.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    val teacherId: Int,
    val name: String,
    val secondName: String?,
    val surname: String,
    val subjectId: Int,
    val login: String,
    var password: String,
    /** дата без года*/
    val dateOfBirth: String,
    val photo: String?,
    val phoneNumber: String?,
    /** Является ли классным руководителем*/
    val isFormMaster: Boolean = false,
    val formClassMasterNumber: Int?,
    val formClassMasterLetter: String?,
    /** Образование и д.р. */
    val description: String?
)
