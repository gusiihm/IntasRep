package com.example.myapplication.ui

import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract.Root
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCarsBinding
import com.example.myapplication.databinding.FragmentSelectedBinding
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.channels.AsynchronousFileChannel.open
import java.io.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var _binding: FragmentSelectedBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectedBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var data = ""
        val textviw:TextView = binding.textprueba
        if(param1 == 1) {
            textviw.text = "Sedan";
            data = "Sedan"
        }
        when(param1){
            1 -> {textviw.text = "Sedan";
                data = "Sedans"}

            2 -> {textviw.text = "SUV";
                data = "SUV"}

            3 -> {textviw.text = "Pick Up";
                data = "Pick_Up"}

            4 -> {textviw.text = "Hatch Back";
                data = "Hacth_back"}

            5 -> {textviw.text = "Otros";
                data = "Otros"}
            else -> {
                textviw.text = "Fallo"
            }

        }


        try {
            var algo =(activity as MainActivity).give_this_manager()
            binding.rvstrings.layoutManager=algo
            var lista: List<Pair<String,String>> = mutableListOf()
            var a  = requireContext().assets.open("Data_Cars/"+ data+"/name_cars.txt").bufferedReader().use{
               br -> br.lines().forEach{
                    lista += Pair<String,String>(data,it.toString())
                }

            }
            val adapter = adaptercarname(lista)
            binding.rvstrings.adapter=adapter


        }catch (e: IOException) {
            // Exception
            e.printStackTrace()
        }


        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            SelectedFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)

                }
            }
    }

}