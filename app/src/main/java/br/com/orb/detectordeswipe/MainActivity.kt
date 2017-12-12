package br.com.orb.detectordeswipe

import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipeDetector = SwipeDetector { direction -> textView.text = direction?.name }
        gestureDetector = GestureDetectorCompat(this, swipeDetector)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    class SwipeDetector(val listener: (Direction?) -> Unit) : OnSwipeListener() {

        override fun onSwipe(direction: Direction?): Boolean {
            listener(direction)
            return super.onSwipe(direction)
        }

    }
}
