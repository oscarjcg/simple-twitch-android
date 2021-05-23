package com.example.simpletwitch.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.simpletwitch.Adapters.NavAdapter
import com.example.simpletwitch.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var navBar: TabLayout

    private  lateinit var navAdapter: NavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind view
        initView()

        // Init navigation with viewpager2
        navAdapter = NavAdapter(this)
        viewPager2.adapter = navAdapter
        TabLayoutMediator(navBar, viewPager2) { tab, position ->
            var name = getString(R.string.following_tab);
            when(position) {
                NavAdapter.FOLLOWING_POS -> name = getString(R.string.following_tab)
                NavAdapter.DISCOVER_POS -> name = getString(R.string.discover_tab)
                NavAdapter.BROWSE_POS -> name = getString(R.string.browse_tab)
            }
            tab.text= name
        }.attach()

    }

    fun initView() {
        viewPager2 = findViewById(R.id.navViewPager2)
        navBar = findViewById(R.id.navBar)
    }
}