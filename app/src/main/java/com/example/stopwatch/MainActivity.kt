package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var watch : Chronometer
    var offset : Long = 0
    var bool : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        watch = findViewById<Chronometer>(R.id.stopWatch)

    }

    fun startTimer(view: View) {
        if(!bool) {
            watch.base = SystemClock.elapsedRealtime() - offset
            watch.start()
            bool = true
        }

        else {
            watch.base = SystemClock.elapsedRealtime()
            watch.start()
        }
    }
    fun stopTimer(view: View) {

        if(bool) {
            offset = SystemClock.elapsedRealtime() - watch.base
            watch.stop()
            bool = false
        }
    }

    fun resetTimer(view: View) {
        watch.base=SystemClock.elapsedRealtime()
        offset =0
        watch.stop()
    }


}