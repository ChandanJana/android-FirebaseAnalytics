package com.example.firebaseanalyticsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    lateinit var btnFirst: Button
    lateinit var btnSecond: Button
    lateinit var btnThird: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "my_item_id")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        btnFirst = findViewById(R.id.btn_first)
        btnSecond = findViewById(R.id.btn_second)
        btnThird = findViewById(R.id.btn_third)

        btnFirst.setOnClickListener {

            var bundle: Bundle = Bundle()
            bundle.putString("cart", "First Button clicked")

            firebaseAnalytics.logEvent("first_btn", bundle)
        }
        btnSecond.setOnClickListener {
            var bundle: Bundle = Bundle()
            bundle.putString("cod", "Second Button clicked")

            firebaseAnalytics.logEvent("second_btn", bundle)
        }
        btnThird.setOnClickListener {
            var bundle: Bundle = Bundle()
            bundle.putString("direct", "Third Button clicked")

            firebaseAnalytics.logEvent("third_btn", bundle)
        }

    }
}