package com.cornerstoneondemand.expensetracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cornerstoneondemand.expensetracker.R
import com.cornerstoneondemand.expensetracker.database.Expense
import com.cornerstoneondemand.expensetracker.utilities.Category
import com.cornerstoneondemand.expensetracker.utilities.getCategoryName

class ExpenseAdapter(): RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> (){

    private var expenseList = ArrayList<Expense>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.expense_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val currentExpense =expenseList[position]
        holder.category.setText(getCategoryName(currentExpense.category_id.value))
        holder.amount.text = currentExpense.amount.toString()
        holder.note.text = currentExpense.note
     }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    fun setExpense(newExpenseList:List<Expense>){
        expenseList.clear()
        expenseList.addAll(newExpenseList)

        notifyDataSetChanged()
    }

    inner class ExpenseViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val expense_layout = itemView.findViewById<CardView>(R.id.card_layout)
        val category = itemView.findViewById<TextView>(R.id.text_view_category_name)
        val amount = itemView.findViewById<TextView>(R.id.text_view_amount)
        val note = itemView.findViewById<TextView>(R.id.text_view_note)
    }
}