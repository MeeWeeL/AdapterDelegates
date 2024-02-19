package com.meeweel.adapterdelegates.adapter_delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

class DslListAdapterDelegate<I : T, T, V : ViewBinding>(
    private val binding: (parent: ViewGroup) -> V,
    private val on: (item: T) -> Boolean,
    private val initializedBlock: AdapterDelegateViewHolder<I, V>.() -> Unit,
) : ListItemAdapterDelegate<I, T, AdapterDelegateViewHolder<I, V>>() {
    override fun isForViewType(item: T) = on(item)

    override fun onCreateViewHolder(parent: ViewGroup): AdapterDelegateViewHolder<I, V> {
        val binding = binding(parent)
        return AdapterDelegateViewHolder<I, V>(binding).also { holder ->
            initializedBlock(holder)
        }
    }

    override fun onBindViewHolder(item: I, holder: AdapterDelegateViewHolder<I, V>) {
        holder._item = item as Any
        holder._bind?.invoke()
    }

    @Suppress("UNCHECKED_CAST")
    private fun createBindingInstance(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): V {
        val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val vbClass = vbType as Class<V>
        val method = vbClass.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        return method.invoke(null, inflater, container, false) as V
    }
}