package com.example.drawables_dunets_l18

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.drawables_dunets_l18.databinding.BitmapFragmentBinding
import java.io.ByteArrayOutputStream

const val HOMEWORK_TAG = "HOMEWORK_TAG"

class BitmapFragment : Fragment() {

    companion object {
        fun newInstance() = BitmapFragment()
    }

    private var _binding: BitmapFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BitmapFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMagic.setOnClickListener {
            drawLineOnImage()
        }
    }

    private fun drawLineOnImage() {

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.square)
            .copy(Bitmap.Config.ARGB_8888, true)

        val canvas = Canvas(bitmap)

        val paint = Paint().apply {
            isAntiAlias = true
            strokeWidth = 25f
            color = Color.MAGENTA
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
        }

        canvas.drawLine(
            0f,
            0f,
            canvas.width.toFloat(),
            canvas.height.toFloat(),
            paint
        )

        binding.ivSquare.setImageBitmap(bitmap)

        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val biteArray = stream.toByteArray()

        Log.i(HOMEWORK_TAG, biteArray.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}