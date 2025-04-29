package com.example.oneid_pension_system.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oneid_pension_system.R
import com.example.oneid_pension_system.models.Payment

class PaymentAdapter(private val payments: List<Payment>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val tvMethod: TextView = itemView.findViewById(R.id.tvMethod)
        val tvTransactionId: TextView = itemView.findViewById(R.id.tvTransactionId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]
        holder.tvDate.text = "Date: ${payment.date}"
        holder.tvAmount.text = "Amount: ${payment.amount}"
        holder.tvMethod.text = "Method: ${payment.method}"
        holder.tvTransactionId.text = "Txn ID: ${payment.transactionId}"
    }

    override fun getItemCount(): Int = payments.size
}
