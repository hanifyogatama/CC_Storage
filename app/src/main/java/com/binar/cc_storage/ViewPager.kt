package com.binar.cc_storage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        LandingPage_one(),
        LandingPage_two(),
        LandingPage_three()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "Fragment A"
            1-> "Fragment B"
            else -> "Fragment C"
        }
    }
}