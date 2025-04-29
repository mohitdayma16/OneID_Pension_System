package com.example.oneid_pension_system

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PensionSchemeAdapter(private val list: List<PensionScheme>) :
    RecyclerView.Adapter<PensionSchemeAdapter.SchemeViewHolder>() {

    class SchemeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvSchemeTitle)
        val desc: TextView = view.findViewById(R.id.tvSchemeDesc)
        val applyButton: Button = view.findViewById(R.id.btnApplyNow)
        val card: CardView = view.findViewById(R.id.cardScheme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchemeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pension_scheme, parent, false)
        return SchemeViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchemeViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.desc.text = item.description

        // No data passed, just navigate
        holder.applyButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ApplyForPension::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}
