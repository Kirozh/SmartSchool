package com.kirozh.smartschool.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kirozh.smartschool.data.models.Absence
import com.kirozh.smartschool.data.models.ClassNumber
import com.kirozh.smartschool.data.models.Lesson
import com.kirozh.smartschool.data.models.Mark
import com.kirozh.smartschool.data.models.Parent
import com.kirozh.smartschool.data.models.Student
import com.kirozh.smartschool.data.models.Subject
import com.kirozh.smartschool.data.models.Teacher

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