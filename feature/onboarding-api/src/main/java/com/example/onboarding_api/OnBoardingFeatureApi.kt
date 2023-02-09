package com.example.onboarding_api

import com.example.feature_api.FeatureApi

interface OnBoardingFeatureApi: FeatureApi {

    fun onBoardingRoute():String
}