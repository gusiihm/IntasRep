package com.example.myapplication.ui.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentCarsBinding

class CarsFragment : Fragment() {

    private var _binding: FragmentCarsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val carViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(CarsViewModel::class.java)

        _binding = FragmentCarsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView1: TextView = binding.sedanTextMenu
        carViewModel.text1.observe(viewLifecycleOwner) {
            textView1.text = it
        }
        val textView2: TextView = binding.textPicUpMenu
        carViewModel.text2.observe(viewLifecycleOwner) {
            textView2.text = it
        }
        val textView3: TextView = binding.textSuvMenu
        carViewModel.text3.observe(viewLifecycleOwner) {
            textView3.text = it
        }
        val textView4: TextView = binding.textHatchBackMenu
        carViewModel.text4.observe(viewLifecycleOwner) {
            textView4.text = it
        }
        val textView5: TextView = binding.textOtrosMenu
        carViewModel.text5.observe(viewLifecycleOwner) {
            textView5.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}