package com.example.simpletwitch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.BrowseNavAdapter
import com.example.simpletwitch.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_browse.*


/**
 * A simple [Fragment] subclass.
 * Use the [BrowseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BrowseFragment : Fragment() {

    private lateinit var browseNavAdapter: BrowseNavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_browse, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init navigation with viewpager2
        browseNavAdapter = BrowseNavAdapter(activity as MainActivity)
        navViewPager2.adapter = browseNavAdapter
        TabLayoutMediator(navBar, navViewPager2) { tab, position ->
            var name = getString(R.string.following_tab);
            when(position) {
                BrowseNavAdapter.CATEGORIES_POS -> name = getString(R.string.categories_tab)
                BrowseNavAdapter.CHANNELS_POS -> name = getString(R.string.live_channels_tab)
            }
            tab.text= name
        }.attach()
    }

    private fun initView() {
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BrowseFragment.
         */
        @JvmStatic
        fun newInstance() =
            BrowseFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
