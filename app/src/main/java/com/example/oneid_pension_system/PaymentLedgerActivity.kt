package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneid_pension_system.adapters.PaymentAdapter
import com.example.oneid_pension_system.models.Payment

class PaymentLedgerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var paymentAdapter: PaymentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_ledger)

        var back = findViewById<TextView>(R.id.PL_btnBack)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
            finish()
        }

        // Sample Payment Data
        val paymentList = listOf(
            Payment("12 April 2025", "₹4,500", "Bank Transfer", "TXN1234567890"),
            Payment("12 March 2025", "₹4,500", "Bank Transfer", "TXN1234567812"),
            Payment("12 February 2025", "₹4,500", "UPI", "TXN1224567890"),
            Payment("12 January 2025", "₹4,500", "NEFT", "TXN9874561230"),
            Payment("12 December 2024", "₹4,500", "Bank Transfer", "TXN5647382910"),
            Payment("12 November 2024", "₹4,500", "NEFT", "TXN6748293640")
        )

        recyclerView = findViewById(R.id.recyclerPaymentHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)
        paymentAdapter = PaymentAdapter(paymentList)
        recyclerView.adapter = paymentAdapter
    }
}
