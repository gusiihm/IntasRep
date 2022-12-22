package com.example.myapplication.ui.search

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R

class adapter2infocar(private val lista:List<String>): RecyclerView.Adapter<holderStrings3>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderStrings3 {
        val layoutInflater= LayoutInflater.from(parent.context)
        return holderStrings3(layoutInflater.inflate(R.layout.data_text_car,parent,false))
    }

    override fun onBindViewHolder(p0: holderStrings3, p1: Int) {
        p0.render(lista[p1])
    }

    override fun getItemCount():  Int = lista.size


}

class holderStrings3(val view: View): RecyclerView.ViewHolder(view){
    val string =view.findViewById<TextView>(R.id.textinfocar1)
    fun render(pair: String){

        string.text = pair.toString()

    }
}