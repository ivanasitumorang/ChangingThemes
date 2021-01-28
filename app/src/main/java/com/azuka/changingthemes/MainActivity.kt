package com.azuka.changingthemes

import android.os.Bundle
import com.azuka.changingthemes.Constant.Themes
import com.azuka.changingthemes.adapter.TabAdapter
import com.azuka.changingthemes.base.BaseActivity
import com.azuka.changingthemes.databinding.ActivityMainBinding
import com.azuka.changingthemes.sharedpreference.ThemeSession
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private val TAB_TITLES = arrayOf("Summary", "Button", "Settings")
    }

    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onLoadActivity(savedInstanceState: Bundle?) {
        val viewPager = binding.pager
        val tabLayout = binding.tabLayout

        val tabAdapter = TabAdapter(this)
        viewPager.adapter = tabAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]

        }.attach()
    }

    private fun setTheme() {
        when (themeSession.getTheme()) {
            Themes.PINK -> setTheme(R.style.Theme_Azuka_Pink)
            Themes.BLUE -> setTheme(R.style.Theme_Azuka_Blue)
            else -> setTheme(R.style.Theme_Azuka)
        }
    }
}