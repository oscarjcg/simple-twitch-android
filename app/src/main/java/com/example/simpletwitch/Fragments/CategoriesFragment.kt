package com.example.simpletwitch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.CategoryAdapter
import com.example.simpletwitch.R

class CategoriesFragment : Fragment() {

    private lateinit var categoriesRv: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        initView(view)

        // Test
        val categories = ArrayList<String>()
        categories.add("Cat 1")
        categories.add("Cat 2")

        // Init category list
        categoryAdapter = CategoryAdapter(categories, activity as MainActivity)
        categoriesRv.layoutManager = LinearLayoutManager(activity)
        categoriesRv.adapter = categoryAdapter

        return view
    }

    private fun initView(view: View) {
        categoriesRv = view.findViewById(R.id.categoriesRv)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                CategoriesFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}