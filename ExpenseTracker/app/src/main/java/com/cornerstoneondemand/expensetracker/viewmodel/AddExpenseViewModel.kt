package com.cornerstoneondemand.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class AddExpenseViewModel(application: Application):AndroidViewModel(application) {
    var selectedDate: MutableLiveData<Date> = MutableLiveData()
}