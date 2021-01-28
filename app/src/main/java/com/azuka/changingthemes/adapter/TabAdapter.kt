package com.azuka.changingthemes.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azuka.changingthemes.fragment.ButtonFragment
import com.azuka.changingthemes.fragment.SettingsFragment
import com.azuka.changingthemes.fragment.SummaryFragment


/**
 * Created by ivanaazuka on 27/01/21.
 * Android Engineer
 */

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> SummaryFragment()
            1 -> ButtonFragment()
            2 -> SettingsFragment()
            else -> SummaryFragment()
        }

}