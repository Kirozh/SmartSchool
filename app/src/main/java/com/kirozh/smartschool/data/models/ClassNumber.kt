package com.kirozh.smartschool.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClassNumber (
    @PrimaryKey(autoGenerate = true)
    val classNumberId: Int,
    /** Номер класса: 11 */
    val number: Int,
    /** Литера класса: А */
    val letter: String
)
