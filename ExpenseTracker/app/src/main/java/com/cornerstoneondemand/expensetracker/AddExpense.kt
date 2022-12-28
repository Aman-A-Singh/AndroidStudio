package com.cornerstoneondemand.expensetracker

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cornerstoneondemand.expensetracker.database.Expense
import com.cornerstoneondemand.expensetracker.databinding.ActivityAddExpenseBinding
import com.cornerstoneondemand.expensetracker.utilities.Category
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
            binding.textViewDate.setText(dateFormat.format(date))
        })

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Add Transaction"

        val payment_modes = resources.getStringArray(R.array.payment_mode)
        val arrayAdapter = ArrayAdapter(this, R.layout.custom_dropdown_payment_mode,payment_modes)
        binding.spinnerPaymentMode.adapter = arrayAdapter

        binding.category.setOnClickListener {
            val intent: Intent = Intent(this,CategoryActivity::class.java)
            startActivity((intent)) }
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
        var amount = binding.editTvAmount.text.toString().toDouble()
        var category = Category.INVESTMENT
        var note = binding.editTextWriteNote.text.toString()
        var mode = binding.spinnerPaymentMode.selectedItem.toString()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        var date =dateFormat.parse(binding.textViewDate.text.toString())

        if(category!=null){
            val expense:Expense = Expense(0,amount,category,note,date,mode)
            viewModel.insert(expense)
        }
        finish()
    }
}