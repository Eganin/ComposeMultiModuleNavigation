package com.example.dependency_provider

import com.example.home_api.HomeFeatureApi
import com.example.onboarding_api.OnBoardingFeatureApi
import com.example.settings_api.SettingsFeatureApi

object DependencyProvider {

    private lateinit var homeFeatureApi: HomeFeatureApi
    private lateinit var settingsFeatureApi: SettingsFeatureApi
    private lateinit var onBoardingFeatureApi: OnBoardingFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi,
        settingsFeatureApi: SettingsFeatureApi,
        onBoardingFeatureApi: OnBoardingFeatureApi
    ) {
        this.homeFeatureApi = homeFeatureApi
        this.settingsFeatureApi = settingsFeatureApi
        this.onBoardingFeatureApi = onBoardingFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi

    fun settingsFeature(): SettingsFeatureApi = settingsFeatureApi

    fun onBoardingFeature(): OnBoardingFeatureApi = onBoardingFeatureApi
}