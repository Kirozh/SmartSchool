package com.kirozh.smartschool.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val lessonId: Int,
    val title: String,
    val teacherId: Int, // todo make Teacher entity class
    val classNumberId: Int,
    /** Номер кабинета */
    val roomNumber: String,
    /** Тема урока */
    var lessonTheme: String,
//    val lessonTime: LessonTime,
    val lessonDayOfWeek: String,
    /** Дата урока - для тех что не каждую неделю */
    val lessonDate: String,
    val lessonNumber: Int,
    /** Комментарий к уроку, например Не забыть цветные карандаши или Контрольная работа */
    val commentary: String,
    /** Было ли задано д/з */
    var isHomeworkGiven: Boolean,
    /** Контрольная, самостоятельная или обычный урок */
    var lessonType: String,
)