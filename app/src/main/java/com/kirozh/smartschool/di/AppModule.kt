package com.kirozh.smartschool.di

import com.kirozh.smartschool.data.remote.SmartSchoolApi
import com.kirozh.smartschool.data.repository.StudentRepositoryImpl
import com.kirozh.smartschool.domain.repository.StudentRepository
import com.kirozh.smartschool.presentation.viewModels.StudentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .build()
            .create(SmartSchoolApi::class.java)
    }

    single<StudentRepository> {
        StudentRepositoryImpl(get())
    }

    viewModel {
        StudentViewModel(get())
    }
}
