package com.example.simpletwitch.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simpletwitch.Fragments.*


class BrowseNavAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            CHANNELS_POS -> ChannelsFragment.newInstance()
            CATEGORIES_POS -> CategoriesFragment.newInstance()
            else -> FollowingFragment.newInstance()
        }
    }

    companion object {
        const val NUM_PAGES = 2;
        const val CHANNELS_POS = 0;
        const val CATEGORIES_POS = 1;
    }
}