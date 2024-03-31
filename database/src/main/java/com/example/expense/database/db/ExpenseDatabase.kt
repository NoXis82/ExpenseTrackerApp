package com.example.expense.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expense.database.dao.ExpenseDao
import com.example.expense.database.model.ExpenseEntity

@Database(
    entities = [ExpenseEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    companion object {
        @JvmStatic
        fun getExpenseDb(applicationContext: Context): ExpenseDatabase {
            return Room.databaseBuilder(
                applicationContext,
                ExpenseDatabase::class.java,
                "expenses_db"
            ).build()
        }
    }
}
