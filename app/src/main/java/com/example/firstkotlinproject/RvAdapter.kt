package com.example.firstkotlinproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val todo:List<ToDo>,val context: Context) : RecyclerView.Adapter<RvAdapter.CustView>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustView {


        return CustView(LayoutInflater.from(context).inflate(R.layout.layout_todo_view,parent,false))


    }

    override fun getItemCount(): Int {

        return todo.size

    }

    override fun onBindViewHolder(holder: CustView, position: Int) {


        holder.tvTitle.text=todo[position].title



    }


    class CustView(view: View): RecyclerView.ViewHolder(view){
        val tvTitle:TextView=view.findViewById(R.id.tv_title);

    }


}