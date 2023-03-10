package com.example.myapplication.ui.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.FragmentCarsBinding
import com.example.myapplication.ui.SelectedFragment


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
        textView1.setOnClickListener{
            val fragment = SelectedFragment.newInstance(1)
            (activity as MainActivity).replaceFragment(fragment)
        }
        carViewModel.text1.observe(viewLifecycleOwner) {
            textView1.text = it
        }
        val textView2: TextView = binding.textPicUpMenu
        carViewModel.text2.observe(viewLifecycleOwner) {
            textView2.text = it
        }
        textView2.setOnClickListener{
            val fragment = SelectedFragment.newInstance(2)
            (activity as MainActivity).replaceFragment(fragment)
        }
        val textView3: TextView = binding.textSuvMenu
        carViewModel.text3.observe(viewLifecycleOwner) {
            textView3.text = it
        }
        textView3.setOnClickListener{
            val fragment = SelectedFragment.newInstance(3)
            (activity as MainActivity).replaceFragment(fragment)
        }
        val textView4: TextView = binding.textHatchBackMenu
        carViewModel.text4.observe(viewLifecycleOwner) {
            textView4.text = it
        }
        textView4.setOnClickListener{
            val fragment = SelectedFragment.newInstance(4)
            (activity as MainActivity).replaceFragment(fragment)
        }
        val textView5: TextView = binding.textOtrosMenu
        carViewModel.text5.observe(viewLifecycleOwner) {
            textView5.text = it
        }
        textView5.setOnClickListener{
            val fragment = SelectedFragment.newInstance(5)
            (activity as MainActivity).replaceFragment(fragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}