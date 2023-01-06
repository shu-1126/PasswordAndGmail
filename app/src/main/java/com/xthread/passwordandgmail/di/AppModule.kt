package com.xthread.passwordandgmail.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.xthread.passwordandgmail.data.repository.AuthRepository
import com.xthread.passwordandgmail.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule{
    //FirebaseAuthをrepository経由で与える
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )
}
