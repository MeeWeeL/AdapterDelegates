package com.meeweel.adapterdelegates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meeweel.adapterdelegates.adapter_delegate.AdapterDelegateManager
import com.meeweel.adapterdelegates.adapter_delegate.DelegationAdapter
import com.meeweel.adapterdelegates.databinding.ActivityMainBinding
import com.meeweel.adapterdelegates.item_1.Item1
import com.meeweel.adapterdelegates.item_1.Item1Delegate
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
            Item1Delegate(),
            Item2Delegate(),
        )
        val adapter = DelegationAdapter(delegateManager, list)
        binding.recycler.adapter = adapter
    }
}