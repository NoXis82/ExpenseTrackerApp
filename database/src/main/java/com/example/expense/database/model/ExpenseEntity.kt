package com.example.expense.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "expense_table")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("amount") val amount: Double,
    @ColumnInfo("date") val date: Long,
    @ColumnInfo("category") val category: String,
    @ColumnInfo("type") val type: String,
)