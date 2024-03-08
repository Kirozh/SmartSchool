package com.kirozh.smartschool.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kirozh.smartschool.domain.models.Absence
import com.kirozh.smartschool.domain.models.ClassNumber
import com.kirozh.smartschool.domain.models.Lesson
import com.kirozh.smartschool.domain.models.Mark
import com.kirozh.smartschool.domain.models.Parent
import com.kirozh.smartschool.domain.models.Student
import com.kirozh.smartschool.domain.models.Subject
import com.kirozh.smartschool.domain.models.Teacher

@Database(
    entities = [
        Absence::class,
        ClassNumber::class,
        Lesson::class,
        Mark::class,
        Parent::class,
        Student::class,
        Subject::class,
        Teacher::class,
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun schoolDao(): SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    SchoolDatabase::class.java, "school.db")
                    .build().also { INSTANCE = it }
            }
        }
    }
}