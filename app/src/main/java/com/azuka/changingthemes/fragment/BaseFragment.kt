package com.azuka.changingthemes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 * Created by ivanaazuka on 27/01/21.
 * Android Engineer
 */

abstract class BaseFragment: Fragment() {

    abstract val viewLayout: Int

    abstract fun onFragmentReady(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(viewLayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentReady(savedInstanceState)
    }
}