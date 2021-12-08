package com.example.simpletwitch.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.SearchAdapter
import com.example.simpletwitch.R
import com.example.simpletwitch.ViewModels.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    val model: SearchViewModel by activityViewModels()

    lateinit var searchAdapter: SearchAdapter

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
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAdapter = SearchAdapter(ArrayList(), activity as MainActivity)
        searchRv.layoutManager = LinearLayoutManager(activity)
        searchRv.adapter = searchAdapter
        model.searchResults.observe(viewLifecycleOwner, { searchResults ->
            searchAdapter = SearchAdapter(ArrayList(searchResults), activity as MainActivity)
            searchRv.adapter = searchAdapter
        })
    }

    override fun onResume() {
        super.onResume()
        model.showingSearchResults = true
    }

    override fun onPause() {
        super.onPause()
        model.showingSearchResults = false
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SearchFragment.
         */
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
