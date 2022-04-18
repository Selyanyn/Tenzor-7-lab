package com.example.a7_animation_scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(
                R.anim.fragment_animation,
                R.anim.backwards_fragment_animation,
                0,
                R.anim.backwards_fragment_animation)
            transaction.add(R.id.fragment_container, AnimationFragment(), "animation_fragment")
                .addToBackStack(null)
                .commit()
        }
    }
}