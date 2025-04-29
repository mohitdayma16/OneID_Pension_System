package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PensionSchemesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var schemesAdapter: PensionSchemeAdapter
    private lateinit var schemeList: List<PensionScheme>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pension_schemes)

        var back = findViewById<TextView>(R.id.PS_btnBack)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
            finish()
        }


        recyclerView = findViewById(R.id.recyclerSchemes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        schemeList = listOf(
            PensionScheme(
                "Atal Pension Yojana",
                "Government-backed pension scheme for unorganized sector workers. Monthly contributions provide pension after age 60."
            ),
            PensionScheme(
                "Employees’ Provident Fund (EPF)",
                "Mandatory for salaried employees in India. Accumulates savings with employer contributions for retirement."
            ),
            PensionScheme(
                "National Pension System (NPS)",
                "Voluntary scheme by Government of India. Offers market-linked returns and tax benefits for all Indian citizens."
            ),
            PensionScheme(
                "Indira Gandhi National Old Age Pension Scheme (IGNOAPS)",
                "Provides financial assistance to senior citizens from BPL families aged 60 years and above."
            ),
            PensionScheme(
                "Pradhan Mantri Vaya Vandana Yojana (PMVVY)",
                "Pension scheme for senior citizens offering a guaranteed return on investments through LIC."
            ),
            PensionScheme(
                "Public Provident Fund (PPF)",
                "Long-term savings scheme with tax benefits and interest for all Indian residents."
            )
        )

        schemesAdapter = PensionSchemeAdapter(schemeList)
        recyclerView.adapter = schemesAdapter
    }
}
