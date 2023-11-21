package com.example.sharedprefcompose.di

import android.content.Context
import com.example.sharedprefcompose.DatastoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatastoreManagerModule {
    @Singleton
    @Provides
    fun provideDataStoreModule(@ApplicationContext context:Context):DatastoreManager{
        return DatastoreManager(context)
    }
}