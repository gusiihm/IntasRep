package com.example.myapplication.ui.likes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.widget.Button
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.FragmentLikesBinding
import com.example.myapplication.ui.adaptercarname
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class LikesFragment : Fragment() {

    private var _binding: FragmentLikesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                LikesViewModel::class.java
            )

        _binding = FragmentLikesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var fileInputStream: FileInputStream? =null
        var list:List<Pair<String,String>> = mutableListOf()

        var button :Button = binding.button

        try {
            fileInputStream = (activity as MainActivity).openFileInput("carsafe")
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            bufferedReader.use { br ->
                br.lines().forEach{
                    var a =it.toString().split(":")
                    if (a.size>1){
                        list+=Pair(a[0],a[1])

                    }
                }            }

        }catch (e: Exception){
            e.printStackTrace()
        }
        var algo =(activity as MainActivity).give_this_manager()
        binding.rvLikes.layoutManager=algo
        val adapter =adaptercarname(list)
        binding.rvLikes.adapter=adapter

        button.setOnClickListener{
            var fileOutputStream: FileOutputStream
            fileOutputStream= (activity as MainActivity).openFileOutput("carsafe", Context.MODE_PRIVATE)
            fileOutputStream.write("".toByteArray())
            (activity as MainActivity).create_toast("Eliminado todos los guardados")
            var list2:List<Pair<String,String>> = mutableListOf()
            val adapter2 =adaptercarname(list2)
            binding.rvLikes.adapter=adapter2
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}