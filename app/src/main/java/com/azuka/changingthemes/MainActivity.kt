package com.azuka.changingthemes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.azuka.changingthemes.adapter.TabAdapter
import com.azuka.changingthemes.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAB_TITLES = arrayOf("Summary", "Button")
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = binding.pager
        val tabLayout = binding.tabLayout

        val tabAdapter = TabAdapter(this)
        viewPager.adapter = tabAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]

        }.attach()
    }
}