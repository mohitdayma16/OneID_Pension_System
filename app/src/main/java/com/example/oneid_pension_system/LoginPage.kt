package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvForgotPassword: TextView
    private lateinit var tvErrorMessage: TextView

    private val validUsername = "user"
    private val validPassword = "password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        tvErrorMessage = findViewById(R.id.tvErrorMessage)

        btnLogin.setOnClickListener {
            handleLogin()
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleLogin() {
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()


        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Proceed to the next screen (Main Dashboard)
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
            finish()
        } else {
            tvErrorMessage.text = "Please enter both username and password"
            tvErrorMessage.visibility = View.VISIBLE
        }
    }
}