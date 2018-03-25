package com.gdgnitsurat.quickshare.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gdgnitsurat.quickshare.fragments.TabFragment


/**
 * Created by yolo on 25/3/18.
 */
class FragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    internal val PAGE_COUNT = 5
    private val tabTitles = arrayOf("Device1", "Device2","Device3","Device4","Device5")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return TabFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

}