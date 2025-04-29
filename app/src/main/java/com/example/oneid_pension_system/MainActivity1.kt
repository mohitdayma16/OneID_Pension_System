package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
//import com.example.yourapp.ApplyForPension

class MainActivity1 : AppCompatActivity() {

    private lateinit var btnApplicationStatus: ImageButton
    private lateinit var btnPaymentLedger: ImageButton
    private lateinit var btnEligibility: ImageButton
    private lateinit var btnPensionFlow: ImageButton
    private lateinit var btnPensionSchemes: ImageButton
    private lateinit var btnApplyPension: ImageButton

    private lateinit var languageGroup: RadioGroup
    private lateinit var rbHindi: RadioButton
    private lateinit var rbEnglish: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        // Initialize buttons
        btnApplicationStatus = findViewById(R.id.btn_application_status)
        btnPaymentLedger = findViewById(R.id.btn_payment_ledger)
        btnEligibility = findViewById(R.id.btn_eligibility)
        btnPensionFlow = findViewById(R.id.btn_pension_flow)
        btnPensionSchemes = findViewById(R.id.btn_pension_schemes)
        btnApplyPension = findViewById(R.id.btn_apply_pension)

        // Language selection
        languageGroup = findViewById(R.id.languageGroup)
        rbHindi = findViewById(R.id.rbHindi)
        rbEnglish = findViewById(R.id.rbEnglish)

        // Set click listeners
        btnApplicationStatus.setOnClickListener {
            showToast("Application Status clicked")
            val intent = Intent(this, ApplicationStatusActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnPaymentLedger.setOnClickListener {
            showToast("Payment Ledger clicked")
            val intent = Intent(this, PaymentLedgerActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnEligibility.setOnClickListener {
            showToast("Eligibility clicked")
            val intent = Intent(this, EligibilityActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnPensionFlow.setOnClickListener {
            showToast("Pension Flow clicked")
            val intent = Intent(this, ContactAndRatingActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnPensionSchemes.setOnClickListener {
            showToast("Pension Schemes clicked")
            val intent = Intent(this, PensionSchemesActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnApplyPension.setOnClickListener {
            showToast("Apply for Pension clicked")

            val intent = Intent(this, ApplyForPension::class.java)
            startActivity(intent)
            finish()

        }

        // Language switcher
        languageGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbHindi -> showToast("Hindi selected")
                R.id.rbEnglish -> showToast("English selected")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
