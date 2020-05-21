package com.example.igdb.utils

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.AttributeSet
import androidx.core.content.ContextCompat.startActivity
import com.example.igdb.activities.MainActivity

class Typewriter : androidx.appcompat.widget.AppCompatTextView {
    private var mText: CharSequence? = null
    private var mIndex = 0
    private var mDelay: Long = 500 //Default 500ms delay

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    )

    private val mHandler = Handler()
    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = mText!!.subSequence(0, mIndex++)
            if (mIndex <= mText!!.length) {
                mHandler.postDelayed(this, mDelay)
            }
        }
    }

    fun animateText(text: CharSequence?) {
        mText = text
        mIndex = 0
        setText("")
        mHandler.removeCallbacks(characterAdder)
        mHandler.postDelayed(characterAdder, mDelay)
    }

    private fun startMainActivity(text: CharSequence?){
        if(text?.lastIndex == text?.length){
            val intent = Intent(context, MainActivity::class.java).also {
                startActivity(context,it,null)
            }
        }
    }

}
