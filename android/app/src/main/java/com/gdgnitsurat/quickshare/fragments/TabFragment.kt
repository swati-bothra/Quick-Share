package com.gdgnitsurat.quickshare.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdgnitsurat.quickshare.R
import kotlinx.android.synthetic.main.fragment_tab.*
import kotlinx.android.synthetic.main.fragment_tab.view.*


/**
 * Created by yolo on 25/3/18.
 */

class TabFragment : Fragment() {

    private var mPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPage = arguments!!.getInt(ARG_PAGE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
        view.deviceFrag.text = "Fragment #" + mPage
        return view
    }

    companion object {
        val ARG_PAGE = "ARG_PAGE"

        fun newInstance(page: Int): TabFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = TabFragment()
            fragment.arguments = args
            return fragment
        }
    }
}