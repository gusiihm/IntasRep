package com.example.myapplication.ui

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R

class adapter1infocar(private val lista:List<String>): RecyclerView.Adapter<holderStrings2>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderStrings2 {
        val layoutInflater= LayoutInflater.from(parent.context)
        return holderStrings2(layoutInflater.inflate(R.layout.data_text_car,parent,false))
    }

    override fun onBindViewHolder(p0: holderStrings2, p1: Int) {
        p0.render(lista[p1])
    }

    override fun getItemCount():  Int = lista.size


}

class holderStrings2(val view: View):RecyclerView.ViewHolder(view){
    val string =view.findViewById<TextView>(R.id.textinfocar1)
    fun render(pair: String){

        string.text = Html.fromHtml("<b>"+pair+"</b>")

    }
}