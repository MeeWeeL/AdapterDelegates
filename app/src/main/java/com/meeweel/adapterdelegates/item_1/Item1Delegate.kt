package com.meeweel.adapterdelegates.item_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meeweel.adapterdelegates.adapter_delegate.DelegateItem
import com.meeweel.adapterdelegates.adapter_delegate.ListItemAdapterDelegate
import com.meeweel.adapterdelegates.databinding.ItemCard1Binding

class Item1Delegate : ListItemAdapterDelegate<Item1, DelegateItem, Item1Delegate.ViewHolder1>() {
    override fun isForViewType(items: List<DelegateItem>, position: Int): Boolean {
        return items[position] is Item1
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder1(ItemCard1Binding.inflate(inflater, parent, false))
    }

    override fun isForViewType(item: DelegateItem): Boolean {
        return item is Item1
    }

    override fun onBindViewHolder(item: Item1, holder: ViewHolder1) {
        holder.bind(item)
    }

    class ViewHolder1(
        private val binding: ItemCard1Binding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item1) {
            binding.text.text = item.title
        }
    }
}