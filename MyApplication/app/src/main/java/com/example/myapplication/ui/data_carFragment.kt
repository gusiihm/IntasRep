package com.example.myapplication.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDataCarBinding

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
        requireContext().assets.open("Data_Cars/"+ param1 +"/"+param2+"/data.txt").bufferedReader().use{
                br -> br.lines().forEach{
           string+= it.toString()+"\n"
        }

        }
        val textdata:TextView=binding.textView
        textdata.text= string
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




