package com.example.home.main.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expense.database.model.ExpenseEntity
import com.example.home.main.R

@Composable
fun TransactionList(modifier: Modifier, list: List<ExpenseEntity>) {
    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            Box(modifier = modifier.fillMaxWidth()) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Transactions History", fontSize = 20.sp)
                    Text(text = "See all", fontSize = 16.sp, color = Color.Gray)
                }
            }
        }

        items(list) { item ->
            TransactionItem(
                title = item.title,
                amount = if (item.type == "Income") "+ ${item.amount}" else "- ${item.amount}",
                data = item.date.toString(),
                imageId = when {
                    Category.PAYPAL.category == item.category -> Category.PAYPAL.iconId
                    Category.NETFLIX.category == item.category -> Category.NETFLIX.iconId
                    else -> R.drawable.ic_starbucks
                },
                color = if (item.type == "Income") Color.Green else Color.Red
            )
        }
    }
}

@Composable
fun TransactionItem(title: String, amount: String, data: String, imageId: Int, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    ) {
        Row {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = imageId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                ExpenseTextView(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                ExpenseTextView(text = data, fontSize = 12.sp)
            }
        }
        ExpenseTextView(
            text = amount,
            fontSize = 20.sp,
            color = color,
            modifier = Modifier.align(Alignment.CenterEnd),
            fontWeight = FontWeight.SemiBold,
        )
    }
}

enum class Category(val category: String, val iconId: Int) {
    PAYPAL("PayPal", R.drawable.ic_paypal),
    NETFLIX("Netflix", R.drawable.ic_netflix),
}