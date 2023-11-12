package com.kirozh.smartschool.di

import com.kirozh.smartschool.data.repository.StudentRepositoryImpl
import com.kirozh.smartschool.domain.repository.StudentRepository
import org.koin.dsl.module

val appModule = module {
    // factory
    single<StudentRepository>{
        StudentRepositoryImpl(get())
    }

}