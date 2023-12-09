package com.example.individutugas.animation


import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.individutugas.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val myButton = findViewById<Button>(R.id.myButton)

        val rotationAnimator = ObjectAnimator.ofFloat(myButton, View.ROTATION, 0f, 360f)
        rotationAnimator.duration = 1000

        val colorAnimator = ObjectAnimator.ofArgb(myButton, "textColor", 0xFF000000.toInt(), 0xFFFF0000.toInt())
        colorAnimator.duration = 1000

        val scaleXAnimator = ObjectAnimator.ofFloat(myButton, View.SCALE_X, 1f, 1.5f)
        val scaleYAnimator = ObjectAnimator.ofFloat(myButton, View.SCALE_Y, 1f, 1.5f)
        val stretchAnimatorSet = AnimatorSet()
        stretchAnimatorSet.playTogether(scaleXAnimator, scaleYAnimator)
        stretchAnimatorSet.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(rotationAnimator, colorAnimator, stretchAnimatorSet)
        animatorSet.start()
    }
}
