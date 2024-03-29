package com.kirozh.smartschool.presentation.loginActivity

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.kirozh.smartschool.presentation.viewModels.StudentViewModel

class LoginActivity: ComponentActivity() {

    val studentViewModel: StudentViewModel by viewModels<StudentViewModel>()
}