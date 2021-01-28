package com.azuka.changingthemes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azuka.changingthemes.R
import com.azuka.changingthemes.databinding.ActivityMainBinding
import com.azuka.changingthemes.databinding.FragmentButtonBinding


/**
 * Created by ivanaazuka on 27/01/21.
 * Android Engineer
 */

class ButtonFragment : BaseFragment() {

    private var _binding: FragmentButtonBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var isButtonEnable = true

    override val viewLayout: Int = R.layout.fragment_button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onFragmentReady(view: View, savedInstanceState: Bundle?) {
        binding.btnReset.setOnClickListener {
            binding.btnTest.isEnabled = true
        }

        binding.btnTest.setOnClickListener {
            binding.btnTest.apply {
                isEnabled = !isButtonEnable
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}