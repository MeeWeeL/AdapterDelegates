package com.meeweel.adapterdelegates

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.meeweel.adapterdelegates.adapter_delegate.AdapterDelegateManager
import com.meeweel.adapterdelegates.adapter_delegate.DelegateItem
import com.meeweel.adapterdelegates.adapter_delegate.DelegationAdapter
import com.meeweel.adapterdelegates.adapter_delegate.adapterDelegate
import com.meeweel.adapterdelegates.databinding.ActivityMainBinding
import com.meeweel.adapterdelegates.databinding.ItemCard1Binding
import com.meeweel.adapterdelegates.item_1.Item1
import com.meeweel.adapterdelegates.item_2.Item2
import com.meeweel.adapterdelegates.item_2.Item2Delegate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        val list = listOf(
            Item1("First Item1"),
            Item1("Second Item1"),
            Item2("First Item2"),
            Item1("Third Item1"),
        )
        val delegateManager = AdapterDelegateManager(
            adapterDelegate<Item1, DelegateItem, ItemCard1Binding>(
                viewBinding = { viewGroup ->
                    val inflater = LayoutInflater.from(viewGroup.context)
                    ItemCard1Binding.inflate(inflater, viewGroup, false)
                },
                block = {
                    (binding as ItemCard1Binding).text.text = item.title
                    bind {
                        (binding as ItemCard1Binding).text.text = item.title
                    }
                }
            ),
            Item2Delegate(),
        )
        val adapter = DelegationAdapter(delegateManager, list)
        binding.recycler.adapter = adapter
    }
}