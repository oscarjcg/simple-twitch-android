package com.example.simpletwitch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.FollowingAdapter
import com.example.simpletwitch.R


/**
 * A simple [Fragment] subclass.
 * Use the [FollowingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowingFragment : Fragment() {

    private lateinit var following: RecyclerView

    private lateinit var followingAdapter: FollowingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_following, container, false)
        initView(view)

        // Test
        val data = ArrayList<String>()
        data.add("C1")
        data.add("C2")
        data.add("C3")

        followingAdapter = FollowingAdapter(data, activity as MainActivity)
        following.layoutManager = LinearLayoutManager(activity)
        following.adapter = followingAdapter

        return view
    }

    fun initView(view: View) {
        following = view.findViewById(R.id.following)
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