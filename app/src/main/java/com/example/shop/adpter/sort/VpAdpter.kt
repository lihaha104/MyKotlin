package com.example.shop.adpter.sort

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class VpAdpter(childFragmentManager: FragmentManager,var list: List<Fragment>,var names:List<String>) : FragmentStatePagerAdapter(childFragmentManager) {
    override fun getItem(position: Int): Fragment {
       return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return names[position]
    }
}