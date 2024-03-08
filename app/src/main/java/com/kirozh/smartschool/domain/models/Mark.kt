package com.kirozh.smartschool.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentId: Int,
    val teacherId: Int,
    val subjectId: Int,
    val lessonId: Int,
    val lessonDate: String,
    val lessonDayOfWeek: String,
    val lessonNumber: Int,
    /** Комментарий учителя */
    val teacherCommentary: String?,
)