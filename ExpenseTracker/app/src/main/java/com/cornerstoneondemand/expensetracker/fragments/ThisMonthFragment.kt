package com.cornerstoneondemand.expensetracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cornerstoneondemand.expensetracker.R
import com.cornerstoneondemand.expensetracker.adapters.ExpenseAdapter
import com.cornerstoneondemand.expensetracker.database.ExpenseDatabase
import com.cornerstoneondemand.expensetracker.databinding.FragmentThisMonthBinding
import com.cornerstoneondemand.expensetracker.viewmodel.ThisMonthViewModel

class ThisMonthFragment : Fragment() {

    private lateinit var binding: FragmentThisMonthBinding
    private lateinit var database: ExpenseDatabase
    lateinit var viewModel:ThisMonthViewModel
    lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentThisMonthBinding.inflate(layoutInflater)
        //Initializing the UI
        initUi()
        viewModel = ViewModelProvider(this).get(ThisMonthViewModel::class.java)
        viewModel.thisMonthExpense.observe(this) { list ->
            list?.let{
                adapter.setExpense(list)
            }
        }
    }

    private fun initUi(){
        binding.recyclerViewThisMonth.setHasFixedSize(true)
        binding.recyclerViewThisMonth.layoutManager =LinearLayoutManager(requireContext())
        adapter = ExpenseAdapter(requireActivity())
        binding.recyclerViewThisMonth.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_this_month, container, false)
    }
}