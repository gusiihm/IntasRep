package com.example.myapplication.ui.profile

import android.arch.lifecycle.ViewModelProvider
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.databinding.FragmentProfileBinding

import com.example.myapplication.ui.search.SearchViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProfile
        profileViewModel._text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val img:ImageView =binding.imageView
        var d : Drawable = Drawable.createFromStream( requireContext().assets.open("Data_Cars/5578703.png"), null)
        img.setImageDrawable(d)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}