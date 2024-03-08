package com.kirozh.smartschool.data.remote

import com.kirozh.smartschool.data.remote.dto.LessonDto
import com.kirozh.smartschool.data.remote.dto.StudentDto
import retrofit2.http.GET

interface SmartSchoolApi {

    @GET()
    suspend fun getSchedule(id: String): List<LessonDto>

    @GET()
    suspend fun getStudent(id: String): StudentDto?
}