package com.example.simpletwitch.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simpletwitch.Fragments.BrowseFragment
import com.example.simpletwitch.Fragments.DiscoverFragment
import com.example.simpletwitch.Fragments.FollowingFragment



class NavAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            FOLLOWING_POS -> FollowingFragment.newInstance()
            DISCOVER_POS -> DiscoverFragment.newInstance()
            BROWSE_POS -> BrowseFragment.newInstance()
            else -> FollowingFragment.newInstance()
        }
    }

    companion object {
        const val NUM_PAGES = 3;
        const val FOLLOWING_POS = 0;
        const val DISCOVER_POS = 1;
        const val BROWSE_POS = 2;
    }
}