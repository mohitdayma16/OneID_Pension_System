package com.example.oneid_pension_system.models

data class Payment(
    val date: String,
    val amount: String,
    val method: String,
    val transactionId: String
)
