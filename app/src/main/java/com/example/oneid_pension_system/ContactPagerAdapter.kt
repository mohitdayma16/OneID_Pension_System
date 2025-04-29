package com.example.oneid_pension_system.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.oneid_pension_system.ContactUsFragment
import com.example.oneid_pension_system.RatingFragment

class ContactPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContactUsFragment()
            1 -> RatingFragment()
            else -> ContactUsFragment()
        }
    }
}
