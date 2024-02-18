package com.meeweel.adapterdelegates.item_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meeweel.adapterdelegates.adapter_delegate.AdapterDelegate
import com.meeweel.adapterdelegates.adapter_delegate.DelegateItem
import com.meeweel.adapterdelegates.databinding.ItemCard1Binding

class Item1Delegate : AdapterDelegate<DelegateItem> {
    override fun isForViewType(items: List<DelegateItem>, position: Int): Boolean {
        return items[position] is Item1
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder1(
            ItemCard1Binding.inflate(
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
        (holder as ViewHolder1).bind(items[position] as Item1)
    }

    class ViewHolder1(
        private val binding: ItemCard1Binding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item1) {
            binding.text.text = item.title
        }
    }
}