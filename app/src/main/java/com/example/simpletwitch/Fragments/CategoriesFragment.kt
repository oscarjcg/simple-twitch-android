package com.example.simpletwitch.Fragments

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletwitch.Activities.MainActivity
import com.example.simpletwitch.Adapters.CategoryAdapter
import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.R
import com.example.simpletwitch.Repositories.CategoryRepository
import com.example.simpletwitch.ViewModels.CategoryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesFragment : Fragment() {

    private lateinit var categoriesRv: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private val model: CategoryViewModel by activityViewModels()

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

        // Empty category list
        val categories = ArrayList<Category>()

        // Init category list
        categoryAdapter = CategoryAdapter(categories, activity as MainActivity)
        categoriesRv.layoutManager = LinearLayoutManager(activity)
        categoriesRv.adapter = categoryAdapter

        model.categories.observe(viewLifecycleOwner, Observer<List<Category>> { categories ->
            // Update category list
            categoryAdapter = CategoryAdapter(ArrayList(categories), activity as MainActivity)
            categoriesRv.adapter = categoryAdapter
        })

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