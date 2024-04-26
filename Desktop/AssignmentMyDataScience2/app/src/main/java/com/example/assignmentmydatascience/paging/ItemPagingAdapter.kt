package com.example.assignmentmydatascience.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentmydatascience.data.SaveDataItem
import com.example.assignmentmydatascience.databinding.ListRowBinding


class ItemPagingAdapter : PagingDataAdapter<SaveDataItem, ItemPagingAdapter.ItemViewHolder>(
    COMPARATOR
) {

    class ItemViewHolder(val binding: ListRowBinding): RecyclerView.ViewHolder(binding.root)
    {
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<SaveDataItem>() {
            override fun areItemsTheSame(oldItem: SaveDataItem, newItem: SaveDataItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: SaveDataItem, newItem: SaveDataItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.binding.id.text = item.id.toString()
            holder.binding.title.text = item.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}