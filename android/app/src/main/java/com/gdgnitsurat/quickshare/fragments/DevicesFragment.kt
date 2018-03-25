package com.gdgnitsurat.quickshare.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_devices.*

import com.gdgnitsurat.quickshare.R
import com.gdgnitsurat.quickshare.adapters.FragmentAdapter
import kotlinx.android.synthetic.main.fragment_devices.view.*

class DevicesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_devices, container, false)
        view.viewpager.adapter = FragmentAdapter(fragmentManager)
        view.tabs.setViewPager(view.viewpager)
        return view
    }
}
