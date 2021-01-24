package com.example.drawables_dunets_l18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.drawables_dunets_l18.databinding.GlideTestFragmentBinding

class GlideTestFragment : Fragment() {

    companion object {
        fun newInstance() = GlideTestFragment()
    }

    private var _binding: GlideTestFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val imgUrl =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXf4xndVlMQ5UQLGnDqhsBl8v-m_ZuYOmktA&usqp=CAU&ec=45761791"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GlideTestFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLoad.setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        Glide.with(this)
            .load(imgUrl)
            .placeholder(R.drawable.circle_placehodler)
            .circleCrop()
            .into(binding.ivCat)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}