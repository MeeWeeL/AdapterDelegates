package com.meeweel.adapterdelegates.adapter_delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

inline fun <reified I : T, T, V : ViewBinding> adapterDelegate(
    noinline viewBinding: (parent: ViewGroup) -> V,
    noinline on: (item: T) -> Boolean = { item -> item is I },
    noinline block: AdapterDelegateViewHolder<I, V>.() -> Unit,
): AdapterDelegate<T> {
    return DslListAdapterDelegate(
        binding = viewBinding,
        on = on,
        initializedBlock = block,
    )
}

interface AdapterDelegate<T> {

    fun isForViewType(items: List<T>, position: Int): Boolean
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<T>, position: Int)
}