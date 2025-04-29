package com.example.oneid_pension_system

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val submitBtn = view.findViewById<Button>(R.id.btnSubmitRating)
        val ratingText = view.findViewById<TextView>(R.id.tvRatingResult)

        val backButton = view.findViewById<TextView>(R.id.R_btnBack)
        backButton.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity1::class.java)
            startActivity(intent)
        }


        submitBtn.setOnClickListener {
            val rating = ratingBar.rating
            ratingText.text = "You rated: $rating stars"
            Toast.makeText(requireContext(), "Thank you for rating!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
