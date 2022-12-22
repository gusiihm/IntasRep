package com.example.myapplication.ui

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDataCarBinding
import com.example.myapplication.ui.search.adapter2infocar
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [data_carFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class data_carFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentDataCarBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataCarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView:TextView=binding.textnombrecohe
        textView.text= param2
        var string =""
        var listNameData:List<String> = mutableListOf()
        var listvalData:List<String> = mutableListOf()
        requireContext().assets.open("Data_Cars/"+ param1 +"/"+param2+"/data.txt").bufferedReader().use{
                br -> br.lines().forEach{

            var stg =it.toString().split(":")
            listNameData+= stg[0]
            listvalData += stg[1]

        }}

        try {
            var algo = (activity as MainActivity).give_this_manager()
            binding.datanamecarrv.layoutManager = algo
            var adapternamedata = adapter1infocar(listNameData)
            binding.datanamecarrv.adapter = adapternamedata
            var algo2 = (activity as MainActivity).give_this_manager()
            binding.dataCarrv.layoutManager = algo2
            var adapter2infocar = adapter2infocar(listvalData)
            binding.dataCarrv.adapter = adapter2infocar

        }

    catch (e: IOException) {
        // Exception
        e.printStackTrace()
    }
        val checkBox: CheckBox= binding.radioButton
        var fileInputStream: FileInputStream? =null
        var car_saved: String = ""
        try {
            fileInputStream = (activity as MainActivity).openFileInput("carsafe")
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)

            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            bufferedReader.use { br ->
                br.lines().forEach {
                    if (it == param1+":"+param2) {
                        checkBox.setChecked(true)
                    }
                    car_saved += it.toString()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }

        checkBox.setOnClickListener {
            if (checkBox.isChecked) {
                //guardar datos
                var fileOutputStream:FileOutputStream
                fileOutputStream= (activity as MainActivity).openFileOutput("carsafe",Context.MODE_PRIVATE)
                var aux = param1+":"+param2+"\n"
                car_saved+=aux
                fileOutputStream.write(car_saved.toByteArray())
                (activity as MainActivity).create_toast("Car safe")
            }else{
                var list =car_saved.split(param1+":"+param2+"\n")
                var newcarsafe:String
                if (list.size>1){
                newcarsafe= list[0]+list[1]}else
                {
                    newcarsafe=""
                }
                var fileOutputStream:FileOutputStream
                fileOutputStream= (activity as MainActivity).openFileOutput("carsafe",Context.MODE_PRIVATE)
                fileOutputStream.write(newcarsafe.toByteArray())
                (activity as MainActivity).create_toast("Car remove")
            }
        }
        val img:ImageView = binding.imgCar
        var d :Drawable=Drawable.createFromStream( requireContext().assets.open("Data_Cars/"+ param1 +"/"+param2+"/img.jpg"), null)
        img.setImageDrawable(d)
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment data_carFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String,param2: String) =
            data_carFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }
}




