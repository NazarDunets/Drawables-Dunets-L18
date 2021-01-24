package com.example.drawables_dunets_l18

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.drawables_dunets_l18.databinding.BasicDrawablesFragmentBinding

class BasicDrawablesFragment : Fragment() {

    private var _binding: BasicDrawablesFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    private lateinit var rectangleAnimation: AnimationDrawable

    companion object {
        fun newInstance() = BasicDrawablesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BasicDrawablesFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivAnim.setBackgroundResource(R.drawable.basic_animation)
        rectangleAnimation = binding.ivAnim.background as AnimationDrawable

        binding.tvReactive.setOnClickListener {
            toggleAnimation()
        }
    }

    private fun toggleAnimation() {
        if (rectangleAnimation.isRunning) {
            rectangleAnimation.stop()
        } else {
            rectangleAnimation.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}