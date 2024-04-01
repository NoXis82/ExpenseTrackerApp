package com.example.home.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expense.database.dao.ExpenseDao
import com.example.expense.database.db.ExpenseDatabase
import com.example.expense.database.model.ExpenseEntity

class HomeViewModel(dao: ExpenseDao) : ViewModel() {

    val expenses = dao.getAllExpenses()

    fun getBalance(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Income") {
                total += it.amount
            } else {
                total -= it.amount
            }
        }
        return "$total руб"
    }

    fun getTotalExpense(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Expense") total -= it.amount
        }
        return "$total руб"
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Income") total += it.amount
        }
        return "$total руб"
    }

}

class HomeViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpenseDatabase.getExpenseDb(context).expenseDao
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException()
    }
}