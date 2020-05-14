package com.example.pantaucorona

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val JUMLAH_MENU = 5

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return HomeFragment() }
            1 -> { return ProvinsiFragment() }
            2 -> { return NegaraFragment() }
            3 -> { return TipsFragment() }
            4 -> { return InfoFragment() }
            else -> {
                return NegaraFragment()
            }
        }

    }

}