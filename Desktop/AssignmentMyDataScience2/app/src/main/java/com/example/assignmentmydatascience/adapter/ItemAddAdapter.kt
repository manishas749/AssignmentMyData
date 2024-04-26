package com.example.assignmentmydatascience.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentmydatascience.data.SaveDataItem
import com.example.assignmentmydatascience.databinding.ListRowBinding

class ItemAddAdapter(private val context: Context, private val itemData: List<SaveDataItem>) :
    RecyclerView.Adapter<ItemAddAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.id.text = itemData[position].id.toString()
        holder.binding.title.text = itemData[position].title


    }
}