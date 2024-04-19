package com.example.chapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter(private val itemList: List<String>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.btnItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.button.text = item
        holder.button.setOnClickListener(View.OnClickListener {
            onClick(item)
        })
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}