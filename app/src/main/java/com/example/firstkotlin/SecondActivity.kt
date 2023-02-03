package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class SecondActivity : AppCompatActivity(), FragmentClickListener {
    private val colors: Array<Int> = arrayOf(
        R.color.black, R.color.purple_500, R.color.teal_200, R
            .color.teal_700
    )
    private var secondFragment: SecondFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (savedInstanceState == null) {
            secondFragment = SecondFragment.newInstance("Second", "yeah")
            secondFragment?.apply {
                supportFragmentManager.beginTransaction().add(
                    R.id.fragmentContainerView5, this,
                    secondFragmentTag
                ).addToBackStack(null).commit()
            }
        } else {
            secondFragment = supportFragmentManager.findFragmentByTag(secondFragmentTag) as?
                    SecondFragment
        }
    }

    override fun onChangeColorBackground() {
        findViewById<LinearLayout>(R.id.linearLayout).setBackgroundColor(
            ContextCompat.getColor
                (this, colors[(colors.indices).random()])
        )
    }

    companion object {
        const val secondFragmentTag = "SecondFragment"
    }
}