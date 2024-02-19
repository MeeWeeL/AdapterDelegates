package com.meeweel.adapterdelegates.adapter_delegate

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


class AdapterDelegateViewHolder<T, V : ViewBinding>(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    private object Uninitialized
    internal var _item: Any = Uninitialized
    @Suppress("UNCHECKED_CAST")
    val item: T get() = if (_item === Uninitialized) {
        throw Exception("_item === Uninitialized ERROR")
    } else {
        _item as T
    }

    internal var _bind: (() -> Unit)? = null
        private set

    fun bind(bindingBlock: () -> Unit) {
        this._bind = bindingBlock
    }
}