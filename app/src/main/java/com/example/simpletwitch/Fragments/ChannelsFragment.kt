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
import kotlinx.android.synthetic.main.fragment_channels.*


/**
 * A simple [Fragment] subclass.
 * Use the [ChannelsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChannelsFragment : Fragment() {

    val model : ChannelViewModel by activityViewModels()

    lateinit var channelsAdapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            model.useBigView = it.getBoolean(USE_BIG_VIEW, false)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_channels, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val channels = ArrayList<Channel>()
        channelsAdapter = ChannelAdapter(channels, activity as MainActivity, model.useBigView)
        channelsRv.layoutManager = LinearLayoutManager(activity)
        channelsRv.adapter = channelsAdapter

        model.channels.observe(viewLifecycleOwner, Observer<List<Channel>> { channels ->
            channelsAdapter = ChannelAdapter(ArrayList(channels), activity as MainActivity, model.useBigView)
            channelsRv.adapter = channelsAdapter
        })
    }

    private fun initView() {
    }

    companion object {
        const val USE_BIG_VIEW = "USE_BIG_VIEW"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ChannelsFragment.
         */
        @JvmStatic
        fun newInstance(useBigView: Boolean = false) =
                ChannelsFragment().apply {
                    arguments = Bundle().apply {
                        putBoolean(USE_BIG_VIEW, useBigView)
                    }
                }
    }
}
