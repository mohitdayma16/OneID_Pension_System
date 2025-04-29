package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EligibilityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibility)

        var back = findViewById<TextView>(R.id.EL_btnBack)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
            finish()
        }

        val spinner: Spinner = findViewById(R.id.spinnerEmployment)
        ArrayAdapter.createFromResource(
            this,
            R.array.employment_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        val ageEditText = findViewById<EditText>(R.id.etAge)
        val employmentSpinner = findViewById<Spinner>(R.id.spinnerEmployment)
        val yearsEditText = findViewById<EditText>(R.id.etYears)
        val resultText = findViewById<TextView>(R.id.tvResult)
        val checkBtn = findViewById<Button>(R.id.btnCheck)

        checkBtn.setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val employmentType = employmentSpinner.selectedItem.toString()
            val years = yearsEditText.text.toString().toIntOrNull() ?: 0

            val eligible = age >= 60 && years >= 10 && employmentType != "Unemployed"
            resultText.text = if (eligible) "✅ You are eligible for the pension." else "❌ Not eligible for the pension."
        }
    }
}
