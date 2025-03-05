package com.example.evlezzeti.di

import com.example.evlezzeti.data.datasource.FirestoreDataSource
import com.example.evlezzeti.data.repo.Repository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
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
    fun provideFireStoreDataSource(collection:CollectionReference) : FirestoreDataSource{
        return FirestoreDataSource(collection)
    }

    @Provides
    @Singleton
    fun provideRepository(fds:FirestoreDataSource) : Repository {
        return Repository(fds)
    }
    @Provides
    @Singleton // provideFireStoreDataSource icin Collection sagladik
    fun provideCollectionReference() : CollectionReference{
        return Firebase.firestore.collection("Mutfaklar")
    }
}