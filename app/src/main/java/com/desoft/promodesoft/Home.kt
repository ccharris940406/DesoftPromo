package com.desoft.promodesoft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ret:View = inflater.inflate(R.layout.fragment_home, container, false)
        val nextButton: Button = ret.findViewById(R.id.next_button)
        nextButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_home_to_hold))

        return ret
    }
}