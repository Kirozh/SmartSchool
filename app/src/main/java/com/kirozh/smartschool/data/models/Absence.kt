package com.kirozh.smartschool.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Пропуски занятий */
@Entity
data class Absence(
    @PrimaryKey(autoGenerate = true)
    val absenceId: Int,
    val studentId: Int,
    val subjectId: Int,
    val lessonDate: String,
    val lessonNumber: Int,
)
