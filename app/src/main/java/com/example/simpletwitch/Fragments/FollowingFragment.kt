package com.example.simpletwitch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.ChannelAdapter
import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.R
import com.example.simpletwitch.ViewModels.ChannelViewModel
import kotlinx.android.synthetic.main.fragment_following.*


/**
 * A simple [Fragment] subclass.
 * Use the [FollowingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowingFragment : Fragment() {

    private lateinit var channelAdapter: ChannelAdapter
    private val model: ChannelViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_following, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init channel list
        val channels = ArrayList<Channel>()
        channelAdapter = ChannelAdapter(channels, activity as MainActivity)
        following.layoutManager = LinearLayoutManager(activity)
        following.adapter = channelAdapter

        model.channels.observe(viewLifecycleOwner, Observer { channels ->
            channelAdapter = ChannelAdapter(ArrayList(channels), activity as MainActivity)
            following.adapter = channelAdapter
        })
    }

    fun initView() {
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FollowingFragment.
         */
        @JvmStatic
        fun newInstance() =
                FollowingFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
