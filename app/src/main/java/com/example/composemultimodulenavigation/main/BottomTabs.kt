package com.example.composemultimodulenavigation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composemultimodulenavigation.R
import com.example.dependency_provider.DependencyProvider

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {

    HOME(
        title = R.string.home_label,
        icon = R.drawable.baseline_home_24,
        route = DependencyProvider.homeFeature().homeRoute()
    ),
    SETTINGS(
        title = R.string.settings_label,
        icon = R.drawable.baseline_settings_24,
        route = DependencyProvider.settingsFeature().settingsRoute()
    )
}