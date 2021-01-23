package com.example.customfancontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [FanControlFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FanControlFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fan_control, container, false)

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            this.findNavController().navigate(FanControlFragmentDirections.actionFanControlFragmentToDrawingFragment())
        }
        return view
    }



}