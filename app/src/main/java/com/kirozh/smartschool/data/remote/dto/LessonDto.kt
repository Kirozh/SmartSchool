package com.kirozh.smartschool.data.remote.dto

import com.kirozh.smartschool.domain.models.Lesson

data class LessonDto (
    val lessonId: Int,
    val title: String,
    val teacherId: Int, // todo make Teacher entity class
    val classNumberId: Int,
    /** Номер кабинета */
    val roomNumber: String,
    /** Тема урока */
    var lessonTheme: String,
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

fun LessonDto.toLesson(): Lesson =
    Lesson(
        lessonId = this.lessonId,
        title = this.title,
        teacherId = this.teacherId,
        classNumberId = this.classNumberId,
        roomNumber = this.roomNumber,
        lessonTheme = this.lessonTheme,
        lessonDayOfWeek = this.lessonDayOfWeek,
        lessonDate = this.lessonDate,
        lessonNumber = this.lessonNumber,
        commentary = this.commentary,
        isHomeworkGiven = this.isHomeworkGiven,
        lessonType = this.lessonType,
    )