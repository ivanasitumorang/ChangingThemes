package com.azuka.changingthemes.sharedpreference

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by ivanaazuka on 28/01/21.
 * Android Engineer
 */

class ThemeSession(context: Context): BaseSharedPreferences(context) {
    override val sharedPreferences: SharedPreferences
        get() = applicationContext.getSharedPreferences("theme_session", 0)

    companion object {
        const val PREF_THEME = "pref_theme"
    }

    fun setTheme(theme: String) {
        setString(PREF_THEME, theme)
    }

    fun getTheme(): String? = getString(PREF_THEME, "")
}