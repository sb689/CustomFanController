package com.example.customfancontroller

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class AnimationFragment : Fragment() {

    lateinit var star: ImageView
    lateinit var rotateButton: Button
    lateinit var translateButton: Button
    lateinit var scaleButton: Button
    lateinit var fadeButton: Button
    lateinit var colorizeButton: Button
    lateinit var showerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view: View =  inflater.inflate(R.layout.fragment_animation, container, false)
        star = view.findViewById(R.id.star)
        rotateButton =  view.findViewById<Button>(R.id.rotateButton)
        translateButton = view. findViewById<Button>(R.id.translateButton)
        scaleButton =  view.findViewById<Button>(R.id.scaleButton)
        fadeButton =  view.findViewById<Button>(R.id.fadeButton)
        colorizeButton =  view.findViewById<Button>(R.id.colorizeButton)
        showerButton =  view.findViewById<Button>(R.id.showerButton)

        rotateButton.setOnClickListener {
            rotater()
        }

        translateButton.setOnClickListener {
            translater()
        }

        scaleButton.setOnClickListener {
            scaler()
        }

        fadeButton.setOnClickListener {
            fader()
        }

        colorizeButton.setOnClickListener {
            colorizer()
        }

        showerButton.setOnClickListener {
            shower()
        }
        return view
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(star, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.addListener(object : AnimatorListenerAdapter(){

            override fun onAnimationStart(animation: Animator?) {
                rotateButton.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                rotateButton.isEnabled = true
            }

        })
        animator.start()
    }

    private fun translater() {
    }

    private fun scaler() {
    }

    private fun fader() {
    }

    private fun colorizer() {
    }

    private fun shower() {
    }

}