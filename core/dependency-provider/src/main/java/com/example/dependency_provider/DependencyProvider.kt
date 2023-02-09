package com.example.dependency_provider

import com.example.home_api.HomeFeatureApi

object DependencyProvider {

    private lateinit var homeFeatureApi: HomeFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi
    ){
        this.homeFeatureApi=homeFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi
}