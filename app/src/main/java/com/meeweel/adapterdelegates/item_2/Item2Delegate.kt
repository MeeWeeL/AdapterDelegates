package com.meeweel.adapterdelegates.item_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meeweel.adapterdelegates.adapter_delegate.AdapterDelegate
import com.meeweel.adapterdelegates.adapter_delegate.DelegateItem
import com.meeweel.adapterdelegates.databinding.ItemCard2Binding

class Item2Delegate: AdapterDelegate<DelegateItem> {
    override fun isForViewType(items: List<DelegateItem>, position: Int): Boolean {
        return items[position] is Item2
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder2(
            ItemCard2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<DelegateItem>,
        position: Int
    ) {
        (holder as ViewHolder2).bind(items[position] as Item2)
    }

    class ViewHolder2(
        private val binding: ItemCard2Binding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item2) {
            binding.text.text = item.title
        }
    }
}