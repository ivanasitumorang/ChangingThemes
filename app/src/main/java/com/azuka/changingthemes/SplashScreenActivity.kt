package com.azuka.changingthemes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.azuka.changingthemes.base.BaseActivity
import com.azuka.changingthemes.databinding.ActivitySplashScreenBinding
import com.azuka.changingthemes.sharedpreference.ThemeSession

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun setCustomTheme() {
        when (themeSession.getTheme()) {
            Constant.Themes.PINK -> setTheme(R.style.Theme_Azuka_Pink)
            Constant.Themes.BLUE -> setTheme(R.style.Theme_Azuka_Blue)
            else -> setTheme(R.style.Theme_Azuka)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        disableTheme = true
        super.onCreate(savedInstanceState)
    }

    override fun onLoadActivity(savedInstanceState: Bundle?) {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}