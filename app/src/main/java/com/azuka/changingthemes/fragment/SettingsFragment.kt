package com.azuka.changingthemes.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import com.azuka.changingthemes.Constant
import com.azuka.changingthemes.R
import com.azuka.changingthemes.databinding.FragmentSettingsBinding
import com.azuka.changingthemes.sharedpreference.ThemeSession
import com.jakewharton.processphoenix.ProcessPhoenix


/**
 * Created by ivanaazuka on 28/01/21.
 * Android Engineer
 */

class SettingsFragment : BaseFragment() {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val themeSession: ThemeSession by lazy {
        ThemeSession(requireContext().applicationContext)
    }

    override val viewLayout: Int = R.layout.fragment_settings

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contextThemeWrapper = ContextThemeWrapper(activity, R.style.Theme_Azuka)
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        _binding = FragmentSettingsBinding.inflate(localInflater, container, false)
        return binding.root
    }

    override fun onFragmentReady(view: View, savedInstanceState: Bundle?) {
        binding.btnThemePink.setOnClickListener {
            changeThemePink()
        }

        binding.btnThemeBlue.setOnClickListener {
            changeThemeBlue()
        }

        binding.btnThemeDefault.setOnClickListener {
            changeThemeDefault()
        }

    }

    private fun changeThemePink() {
//        context?.setTheme(R.style.Theme_Azuka_Pink)
        themeSession.setTheme(Constant.Themes.PINK)
        ProcessPhoenix.triggerRebirth(context)
        Log.i("Hasil", "to pink")
    }

    private fun changeThemeBlue() {
//        context?.setTheme(R.style.Theme_Azuka_Blue)
        themeSession.setTheme(Constant.Themes.BLUE)
        ProcessPhoenix.triggerRebirth(context)
        Log.i("Hasil", "to blue")
    }

    private fun changeThemeDefault() {
//        context?.setTheme(R.style.Theme_Azuka)
        themeSession.setTheme(Constant.Themes.DEFAULT)
        ProcessPhoenix.triggerRebirth(context)
        Log.i("Hasil", "to default")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}