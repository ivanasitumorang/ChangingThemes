package com.azuka.changingthemes.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


/**
 * Created by ivanaazuka on 28/01/21.
 * Android Engineer
 */

abstract class BaseSharedPreferences(protected val applicationContext: Context) {

    abstract val sharedPreferences: SharedPreferences

    fun getString(key: String, defaultValue: String): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun setString(key: String, value: String?) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        sharedPreferences.edit {
            putInt(key, value)
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            putBoolean(key, value)
        }
    }

    fun clear() {
        sharedPreferences.edit {
            clear()
        }
    }
}