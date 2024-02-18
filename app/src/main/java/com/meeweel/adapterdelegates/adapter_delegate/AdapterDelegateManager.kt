package com.meeweel.adapterdelegates.adapter_delegate

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterDelegateManager<T>(vararg delegates: AdapterDelegate<T>) {

    private val delegates: SparseArrayCompat<AdapterDelegate<T>> = SparseArrayCompat()

    init {
        for (element in delegates) {
            addDelegate(element)
        }
    }

    private fun addDelegate(delegate: AdapterDelegate<T>) {
        var viewType = delegates.size()
        while (delegates[viewType] != null) {
            viewType++
        }

        delegates.put(viewType, delegate)
    }

    fun getItemViewType(items: List<T>, position: Int): Int {
        val delegatesCount = delegates.size()
        for (i in 0 until delegatesCount) {
            val delegate: AdapterDelegate<T> = delegates.valueAt(i)
            if (delegate.isForViewType(items, position)) {
                return delegates.keyAt(i)
            }
        }
        throw Exception("getItemViewType invalid type")
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val delegate: AdapterDelegate<T> =
            delegates[viewType] ?: throw Exception("onCreateViewHolder invalid type")
        return delegate.onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items: List<T>, holder: ViewHolder, position: Int) {
        val delegate: AdapterDelegate<T> =
            delegates[holder.itemViewType] ?: throw Exception("onBindViewHolder invalid type")
        delegate.onBindViewHolder(holder, items, position)
    }
}