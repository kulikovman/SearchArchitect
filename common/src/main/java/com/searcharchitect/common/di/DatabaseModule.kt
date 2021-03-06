package com.searcharchitect.common.di

import android.content.Context
import androidx.room.Room
import com.searcharchitect.common.database.AppDatabase
import com.searcharchitect.common.database.dao.IContactDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database-searcharchitect")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideContactDao(appDatabase: AppDatabase): IContactDao {
        return appDatabase.contactDao()
    }

}