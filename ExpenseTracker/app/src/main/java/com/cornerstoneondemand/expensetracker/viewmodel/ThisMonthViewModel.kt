package com.cornerstoneondemand.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cornerstoneondemand.expensetracker.database.Expense
import com.cornerstoneondemand.expensetracker.database.ExpenseDatabase

import com.cornerstoneondemand.expensetracker.database.ExpenseRepository

class ThisMonthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository:ExpenseRepository
    val thisMonthExpense : LiveData<List<Expense>>

    init{
        val dao = ExpenseDatabase.getInstance(application).expenseDao()
        repository = ExpenseRepository(dao)
        thisMonthExpense = repository.thisMonthExpense
    }

}