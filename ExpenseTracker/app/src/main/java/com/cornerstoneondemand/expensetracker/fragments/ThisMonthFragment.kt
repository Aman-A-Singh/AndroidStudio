package com.cornerstoneondemand.expensetracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cornerstoneondemand.expensetracker.R
import com.cornerstoneondemand.expensetracker.adapters.ExpenseAdapter
import com.cornerstoneondemand.expensetracker.database.ExpenseDatabase
import com.cornerstoneondemand.expensetracker.databinding.FragmentThisMonthBinding
import com.cornerstoneondemand.expensetracker.viewmodel.ThisMonthViewModel

class ThisMonthFragment : Fragment() {
    lateinit var viewModel:ThisMonthViewModel
    lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Initializing the UI
        val view = inflater.inflate(R.layout.fragment_this_month, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_this_month)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =LinearLayoutManager(activity)
        adapter = ExpenseAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ThisMonthViewModel::class.java)
        viewModel.thisMonthExpense.observe(viewLifecycleOwner) { list ->
            list?.let{
                adapter.setExpense(list)
            }
        }
        return view
    }
}