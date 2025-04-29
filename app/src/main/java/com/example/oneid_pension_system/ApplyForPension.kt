package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ApplyForPension : AppCompatActivity() {

    private lateinit var fullNameEditText: EditText
    private lateinit var pensionSchemeSpinner: Spinner
    private lateinit var submitButton: Button
    private lateinit var uploadButton: Button
    private lateinit var pensionSchemes: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_for_pension)

        // Initialize views
        fullNameEditText = findViewById(R.id.full_name)
        pensionSchemeSpinner = findViewById(R.id.pension_scheme_spinner)
        submitButton = findViewById(R.id.submit_button)
        uploadButton = findViewById(R.id.upload_button)

        // Try to get passed pension schemes list, or fall back to default list
        pensionSchemes = intent.getStringArrayListExtra("PENSION_SCHEMES") ?: listOf(
            "Atal Pension Yojana",
            "Employees’ Provident Fund (EPF)",
            "National Pension System (NPS)",
            "Indira Gandhi National Old Age Pension Scheme (IGNOAPS)",
            "Pradhan Mantri Vaya Vandana Yojana (PMVVY)",
            "Public Provident Fund (PPF)"
        )

        // Populate the spinner
        val pensionSchemeAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            pensionSchemes
        )
        pensionSchemeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        pensionSchemeSpinner.adapter = pensionSchemeAdapter

        // Optional: preselect a scheme if passed
        val selectedScheme = intent.getStringExtra("selectedScheme")
        selectedScheme?.let {
            val index = pensionSchemes.indexOf(it)
            if (index != -1) {
                pensionSchemeSpinner.setSelection(index)
            }
        }

        // Button actions
        submitButton.setOnClickListener {
            submitApplication()
        }

        uploadButton.setOnClickListener {
            openFilePicker()
        }
    }

    private fun submitApplication() {
        val fullName = fullNameEditText.text.toString().trim()
        val selectedScheme = pensionSchemeSpinner.selectedItem.toString()

        if (fullName.isEmpty()) {
            Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Application Submitted for $fullName to $selectedScheme", Toast.LENGTH_LONG).show()

        val intent = Intent(this, ApplicationStatusActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openFilePicker() {
        Toast.makeText(this, "File Picker Opened", Toast.LENGTH_SHORT).show()
    }
}
