package com.example.dependency_provider

import com.example.home_api.HomeFeatureApi
import com.example.settings_api.SettingsFeatureApi

object DependencyProvider {

    private lateinit var homeFeatureApi: HomeFeatureApi
    private lateinit var settingsFeatureApi: SettingsFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi,
        settingsFeatureApi: SettingsFeatureApi
    ) {
        this.homeFeatureApi = homeFeatureApi
        this.settingsFeatureApi = settingsFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi

    fun settingsFeature(): SettingsFeatureApi = settingsFeatureApi
}