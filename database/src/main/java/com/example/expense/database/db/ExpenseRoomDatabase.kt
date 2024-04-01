package com.example.expense.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.expense.database.dao.ExpenseDao
import com.example.expense.database.model.ExpenseEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ExpenseDatabase internal constructor(private val roomDatabase: ExpenseRoomDatabase) {

    val expenseDao: ExpenseDao
        get() = roomDatabase.expenseDao()


    companion object {
        @JvmStatic
        fun getExpenseDb(applicationContext: Context): ExpenseDatabase {
            val expenseRoomDatabase = Room.databaseBuilder(
                applicationContext,
                ExpenseRoomDatabase::class.java,
                "expenses_db"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            val dao = getExpenseDb(applicationContext).expenseDao
                            dao.insertItem(ExpenseEntity(title = "Netflix", amount = 400.00, date = System.currentTimeMillis(), category = "Netflix", type = "Expense"))
                            dao.insertItem(ExpenseEntity(title = "PayPal", amount = 4400.00, date = System.currentTimeMillis(), category = "PayPal", type = "Income"))
                        }
                    }
                })
                .build()
            return ExpenseDatabase(expenseRoomDatabase)
        }
    }
}


@Database(
    entities = [ExpenseEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class ExpenseRoomDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}
