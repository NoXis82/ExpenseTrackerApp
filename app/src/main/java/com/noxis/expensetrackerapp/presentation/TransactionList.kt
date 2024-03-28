package com.noxis.expensetrackerapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noxis.expensetrackerapp.R

@Composable
fun TransactionList(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Box(modifier = modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Transactions History", fontSize = 20.sp)
                Text(text = "See all", fontSize = 16.sp, color = Color.Gray)
            }
        }
        TransactionItem(
            title = "Upwork",
            amount = "+ 850.00 руб",
            data = "Today",
            imageId = R.drawable.ic_upwork,
            color = Color.Green
        )
        TransactionItem(
            title = "Netflix",
            amount = "- 250.00 руб",
            data = "Yesterday",
            imageId = R.drawable.ic_netflix,
            color = Color.Red
        )
        TransactionItem(
            title = "Paypal",
            amount = "+ 1050.00 руб",
            data = "Today",
            imageId = R.drawable.ic_paypal,
            color = Color.Green
        )
        TransactionItem(
            title = "Youtube",
            amount = "- 50.00 руб",
            data = "Today",
            imageId = R.drawable.ic_youtube,
            color = Color.Red
        )
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
                Text(text = title, fontSize = 16.sp)
                Text(text = data, fontSize = 12.sp)
            }
        }
        Text(
            text = amount,
            fontSize = 20.sp,
            color = color,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}