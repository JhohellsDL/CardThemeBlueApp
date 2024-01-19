package com.example.cardthemeblueapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.cardthemeblueapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private const val ANIMATION_DURATION = 1000L

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAgain.setOnClickListener {
            moveTwoText(binding.cardInstagram, binding.cardFacebook, binding.cardLinkedin)
            binding.textName.fadeInAndMoveUp()
            binding.cardImage.fadeInAndMoveUp()
        }

        binding.buttonFollow.setOnClickListener {
            showSnackbar(binding.root, "Following")
        }
        binding.buttonInstagram.setOnClickListener {
            showSnackbar(binding.root, "Go link Instagram")
        }
        binding.buttonFacebook.setOnClickListener {
            showSnackbar(binding.root, "Go link Facebook")
        }
        binding.buttonLinkedin.setOnClickListener {
            showSnackbar(binding.root, "Go link Linkedin")
        }
    }

    private fun moveTwoText(cardView1: CardView, cardView2: CardView, cardView3: CardView) {
        cardView1.alpha = 0f
        cardView2.alpha = 0f
        cardView3.alpha = 0f
        binding.buttonFollow.alpha = 0f

        val fadeInAnimator1 = ObjectAnimator.ofFloat(cardView1, "alpha", 0f, 1f)
        fadeInAnimator1.duration = ANIMATION_DURATION
        val fadeInAnimator2 = ObjectAnimator.ofFloat(cardView2, "alpha", 0f, 1f)
        fadeInAnimator2.duration = ANIMATION_DURATION
        val fadeInAnimator3 = ObjectAnimator.ofFloat(cardView3, "alpha", 0f, 1f)
        fadeInAnimator3.duration = ANIMATION_DURATION

        val animator1 = ObjectAnimator.ofFloat(cardView1, "translationY", 0f, 10f)
        animator1.duration = ANIMATION_DURATION
        val animator2 = ObjectAnimator.ofFloat(cardView2, "translationY", 0f, 10f)
        animator2.duration = ANIMATION_DURATION
        val animator3 = ObjectAnimator.ofFloat(cardView3, "translationY", 0f, 10f)
        animator3.duration = ANIMATION_DURATION


        animator1.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                animator2.start()
                fadeInAnimator2.start()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })
        animator2.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                animator3.start()
                fadeInAnimator3.start()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })

        animator3.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                binding.buttonFollow.fadeInAndMoveUp()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })

        fadeInAnimator1.start()
        animator1.start()
    }

    private fun TextView.fadeInAndMoveUp() {
        alpha = 0f
        translationY = 0f

        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val moveUpAnimator = ObjectAnimator.ofFloat(this, "translationY", 0f, 10f)
        moveUpAnimator.duration = ANIMATION_DURATION


        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, moveUpAnimator)
        animatorSet.start()
    }

    private fun CardView.fadeInAndMoveUp() {
        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val translateAnimator = ObjectAnimator.ofFloat(this, "translationY", 0f, -20f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, translateAnimator)
        animatorSet.start()
    }

    private fun Button.fadeInAndMoveUp() {
        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val translateAnimator = ObjectAnimator.ofFloat(this, "translationY", 0f, -20f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, translateAnimator)
        animatorSet.start()
    }

    private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(getColor(R.color.blue_theme))
            .setTextColor(Color.WHITE)
            .show()
    }
}