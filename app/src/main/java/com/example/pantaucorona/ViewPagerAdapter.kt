package com.example.pantaucorona

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val JUMLAH_MENU = 3

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return MyFriendsFragmen() }
            1 -> { return GithubFragmen() }
            2 -> { return ProfilFragmen() }
            else -> {
                return GithubFragmen()
            }
        }

    }

}