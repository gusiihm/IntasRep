package com.example.myapplication.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.ui.adaptercarname
import com.example.myapplication.ui.holderStrings2

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var editText:EditText =binding.eTserch

        var algo =(activity as MainActivity).give_this_manager()
        var data ="Sedan"
        binding.rvserch.layoutManager=algo
        var lista: List<Pair<String,String>> = mutableListOf()
        lista=leedatos(lista,"Sedans")
        lista=leedatos(lista,"Pick_Up")
        lista=leedatos(lista,"SUV")
        lista=leedatos(lista,"Hacth_back")
        lista=leedatos(lista,"Otros")
        val adaptercarname =adaptercarname(lista)


        binding.rvserch.adapter=adaptercarname
        val button:ImageButton= binding.button2
        button.setOnClickListener{
            var a  =editText.text
            var list2:List<Pair<String,String>> = mutableListOf()
            lista.forEach {
                if ( it.second.toString().contains(a)){
                    list2+=it
                }
            }
            val adaptercarname =adaptercarname(list2)
            binding.rvserch.adapter=adaptercarname


        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun leedatos(list: List<Pair<String,String>>,string: String): List<Pair<String,String>>{
        var list2 =list
        var a  = requireContext().assets.open("Data_Cars/"+ string+"/name_cars.txt").bufferedReader().use { br ->
            br.lines().forEach {

                list2 += Pair<String, String>(string, it.toString())
            }
        }
        return list2
    }

    fun comprueba2(string: String,list: List<Pair<String,String>>):List<Pair<String,String>>{
        var list2:List<Pair<String,String>> = mutableListOf()
        list.forEach {
           if ( it.second.toString().contains(string)){
               list2+=it
           }
        }

            return list2
            }
}