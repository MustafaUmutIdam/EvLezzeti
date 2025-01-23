package com.example.evlezzeti.di

import com.example.evlezzeti.data.datasource.FirestoreDataSource
import com.example.evlezzeti.data.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFireStoreDataSource() : FirestoreDataSource{
        return FirestoreDataSource()
    }

    @Provides
    @Singleton
    fun provideRepository(fds:FirestoreDataSource) : Repository {
        return Repository(fds)
    }
}