package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class ContactUsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_us, container, false)

        val name = view.findViewById<EditText>(R.id.etName)
        val email = view.findViewById<EditText>(R.id.etEmail)
        val subject = view.findViewById<EditText>(R.id.etSubject)
        val message = view.findViewById<EditText>(R.id.etMessage)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)

        val backButton = view.findViewById<TextView>(R.id.CU_btnBack)
        backButton.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity1::class.java)
            startActivity(intent)
        }



        btnSubmit.setOnClickListener {
            val nameText = name.text.toString().trim()
            val emailText = email.text.toString().trim()
            val subjectText = subject.text.toString().trim()
            val messageText = message.text.toString().trim()

            if (nameText.isEmpty() || emailText.isEmpty() || subjectText.isEmpty() || messageText.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Message sent successfully!", Toast.LENGTH_LONG).show()
                name.text.clear()
                email.text.clear()
                subject.text.clear()
                message.text.clear()
            }
        }

        return view
    }
}
