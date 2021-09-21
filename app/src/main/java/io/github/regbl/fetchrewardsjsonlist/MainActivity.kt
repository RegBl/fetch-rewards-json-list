package io.github.regbl.fetchrewardsjsonlist

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : ViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.itemList.observe(this, Observer {
            it?.let {
                itemsAdapter.submitList(it)
            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}