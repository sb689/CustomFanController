package com.example.customfancontroller

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
        Log.d("AnimationFragment", "rotate function called")
        val animator = ObjectAnimator.ofFloat(star, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.disableViewDuringAnimation(rotateButton)
        animator.start()
    }

    private fun translater() {

        val animator = ObjectAnimator.ofFloat(star, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(translateButton)
        animator.start()
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View)
    {
       addListener(object : AnimatorListenerAdapter(){
           override fun onAnimationStart(animation: Animator?) {
              view.isEnabled = false
           }

           override fun onAnimationEnd(animation: Animator?) {
               view.isEnabled = true
           }
       })
    }

    private fun scaler() {

        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(star, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation( scaleButton)
        animator.start()
    }


    private fun fader() {

        val animator = ObjectAnimator.ofFloat(star, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(fadeButton)
        animator.start()
    }

    private fun colorizer() {

        val animator = ObjectAnimator.ofArgb(
            star.parent,
            "backgroundColor",
            Color.BLACK,
            Color.RED )


        animator.setDuration(300)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(colorizeButton)
        animator.start()
    }

    private fun shower() {
    }

}