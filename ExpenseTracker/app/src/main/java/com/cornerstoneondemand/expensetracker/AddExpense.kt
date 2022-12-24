package com.cornerstoneondemand.expensetracker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cornerstoneondemand.expensetracker.databinding.ActivityAddExpenseBinding
import com.cornerstoneondemand.expensetracker.viewmodel.AddExpenseViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddExpense : AppCompatActivity() {
    private lateinit var viewModel : AddExpenseViewModel
    private lateinit var binding: ActivityAddExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AddExpenseViewModel::class.java)

        binding.textViewDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    viewModel.selectedDate.value = Calendar.getInstance().apply {
                        set(Calendar.YEAR, year)
                        set(Calendar.MONTH, month)
                        set(Calendar.DAY_OF_MONTH, day)
                    }.time
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        viewModel.selectedDate.observe(this,{ date ->
            binding.textViewDate.text = dateFormat.format(date)
        })

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Add Expense"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.add_expense_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.save_expense-> {saveExpense()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun saveExpense() {
        var amount = binding.editTvAmount.text
        var category = binding.category.text
        var note = binding.editTextWriteNote
        var mode = binding.editTvMode
    }
}