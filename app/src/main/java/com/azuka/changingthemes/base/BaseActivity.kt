package com.azuka.changingthemes.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.azuka.changingthemes.Constant
import com.azuka.changingthemes.R
import com.azuka.changingthemes.sharedpreference.ThemeSession


/**
 * Created by ivanaazuka on 28/01/21.
 * Android Engineer
 */

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    abstract val binding: T

    abstract fun onLoadActivity(savedInstanceState: Bundle?)

    protected var disableTheme: Boolean = false

    protected val themeSession: ThemeSession by lazy {
        ThemeSession(applicationContext)
    }

    open fun setCustomTheme() {
        when (themeSession.getTheme()) {
            Constant.Themes.PINK -> setTheme(R.style.Theme_Azuka_Pink)
            Constant.Themes.BLUE -> setTheme(R.style.Theme_Azuka_Blue)
            else -> setTheme(R.style.Theme_Azuka)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!disableTheme) {
            setCustomTheme()
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onLoadActivity(savedInstanceState)
    }
}