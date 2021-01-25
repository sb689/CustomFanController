package com.example.customfancontroller

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.drawing_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_drawing -> {
                this.findNavController().navigate(FanControlFragmentDirections.actionFanControlFragmentToDrawingFragment())
                true
            }

            R.id.menu_animate -> {
                this.findNavController().navigate(FanControlFragmentDirections.actionFanControlFragmentToAnimationFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}