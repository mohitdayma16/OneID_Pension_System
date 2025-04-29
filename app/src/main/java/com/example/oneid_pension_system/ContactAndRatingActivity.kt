package com.example.oneid_pension_system


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.oneid_pension_system.adapters.ContactPagerAdapter

class ContactAndRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_and_rating)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ContactPagerAdapter(this)
        viewPager.adapter = adapter
    }
}
