package com.example.a7_animation_scroll

import android.animation.AnimatorInflater
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnimationFragment : Fragment(R.layout.animation_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animateButton = view.findViewById<Button>(R.id.animaton_button)
        animateButton.setOnClickListener {
            val square = view.findViewById<TextView>(R.id.square)
            val rectangle = view.findViewById<TextView>(R.id.rectangle)

            val density = context?.resources?.displayMetrics?.density

            Log.i("AAA", "AAA")

            ValueAnimator.ofInt(rectangle.height, (40 * density!!).toInt()).apply {
                duration = 400L
                addUpdateListener { valueAnimator : ValueAnimator ->
                    val animatedValue = valueAnimator.animatedValue as Int
                    rectangle.layoutParams.height = animatedValue
                    rectangle.requestLayout()
                }
                start()
            }

            ValueAnimator.ofInt(square.height, 60).apply {
                duration = 400L
                start()
            }
        }
    }

}