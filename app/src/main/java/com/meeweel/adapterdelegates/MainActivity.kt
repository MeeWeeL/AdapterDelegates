package com.meeweel.adapterdelegates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meeweel.adapterdelegates.databinding.ActivityMainBinding

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
        val adapter = MainRecyclerAdapter(list)
        binding.recycler.adapter = adapter
    }
}