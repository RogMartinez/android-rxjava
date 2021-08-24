package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unittesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = TextAdapter()
    private val observer = { items: List<String> ->
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.button.setOnClickListener { addWord() }
        ItemsProvider.observable.subscribe(observer)
    }

    fun addWord(){
        val newWord = binding.textBoxAdd.text
        ItemsProvider.addValuesTo(newWord.toString())
    }




    override fun onDestroy() {
        ItemsProvider.observable.unsubscribe(observer)
        super.onDestroy()
    }
}