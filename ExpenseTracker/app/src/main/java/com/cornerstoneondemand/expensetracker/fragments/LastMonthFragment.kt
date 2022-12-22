package com.cornerstoneondemand.expensetracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cornerstoneondemand.expensetracker.R
import com.cornerstoneondemand.expensetracker.adapters.ExpenseAdapter
import com.cornerstoneondemand.expensetracker.database.ExpenseDatabase
import com.cornerstoneondemand.expensetracker.databinding.FragmentFutureBinding
import com.cornerstoneondemand.expensetracker.databinding.FragmentLastMonthBinding
import com.cornerstoneondemand.expensetracker.databinding.FragmentThisMonthBinding
import com.cornerstoneondemand.expensetracker.viewmodel.ThisMonthViewModel


class LastMonthFragment : Fragment() {

    private lateinit var binding: FragmentLastMonthBinding
    private lateinit var database: ExpenseDatabase
    lateinit var viewModel: ThisMonthViewModel
    lateinit var adapter: ExpenseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLastMonthBinding.inflate(layoutInflater)
        //Initializing the UI
        initUi()
        viewModel = ViewModelProvider(requireActivity()).get(ThisMonthViewModel::class.java)
        viewModel.thisMonthExpense.observe(this) { list ->
            list?.let{
                adapter.setExpense(list)
            }
        }
    }

    fun initUi(){
        binding.recyclerViewLastMonth.setHasFixedSize(true)
        binding.recyclerViewLastMonth.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLastMonth.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_month, container, false)
    }
}