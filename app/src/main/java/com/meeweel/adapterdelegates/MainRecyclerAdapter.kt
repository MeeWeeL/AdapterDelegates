package com.meeweel.adapterdelegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.meeweel.adapterdelegates.databinding.ItemCard1Binding
import com.meeweel.adapterdelegates.databinding.ItemCard2Binding

class MainRecyclerAdapter(
    private val list: List<BaseItem>,
) : RecyclerView.Adapter<MainRecyclerAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            1 -> ViewHolder1(
                ItemCard1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            2 -> ViewHolder2(
                ItemCard2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw Exception()
        }
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder) {
            is ViewHolder1 -> holder.bind(list[position] as Item1)
            is ViewHolder2 -> holder.bind(list[position] as Item2)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Item1 -> 1
            is Item2 -> 2
            else -> throw Exception()
        }
    }

    class ViewHolder1(private val binding: ItemCard1Binding) : BaseViewHolder(binding.root) {
        fun bind(item: Item1) {
            binding.text.text = item.title
        }
    }

    class ViewHolder2(private val binding: ItemCard2Binding) : BaseViewHolder(binding.root) {
        fun bind(item: Item2) {
            binding.text.text = item.title
        }
    }

    open class BaseViewHolder(view: View) : ViewHolder(view) {

    }
}