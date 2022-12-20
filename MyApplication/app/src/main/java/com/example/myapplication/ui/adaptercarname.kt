package com.example.myapplication.ui

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class adaptercarname (private val lista:List<Pair<String,String>>):RecyclerView.Adapter<holderStrings>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderStrings {
        val layoutInflater= LayoutInflater.from(parent.context)
        return holderStrings(layoutInflater.inflate(R.layout.itemnamecar,parent,false))
    }

    override fun onBindViewHolder(p0: holderStrings, p1: Int) {
        p0.render(lista[p1])
    }

    override fun getItemCount(): Int = lista.size




}
class holderStrings(val view: View):RecyclerView.ViewHolder(view){
    val string =view.findViewById<TextView>(R.id.textcar_name)
    fun render(pair: Pair<String,String>){
        string.text = pair.second
        string.setOnClickListener{
            val fragment = data_carFragment.newInstance(pair.first,pair.second)
            val activity=it.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,fragment).commitNow()

        }
    }
}