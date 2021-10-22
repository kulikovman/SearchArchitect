package com.example.searcharchitect.di

import com.example.searcharchitect.retrofit.FacebookRequest
import com.example.searcharchitect.retrofit.GoogleSheetsRequest
import com.example.searcharchitect.retrofit.IFacebookRequest
import com.example.searcharchitect.retrofit.IGoogleSheetsRequest
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RequestModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindGoogleSheetsRequest(googleSheetsRequest: GoogleSheetsRequest): IGoogleSheetsRequest

    @Binds
    @ActivityRetainedScoped
    abstract fun bindFacebookRequest(facebookRequest: FacebookRequest): IFacebookRequest

}