package io.github.regbl.fetchrewardsjsonlist

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Here's a console message")

        viewModel.itemList.observe(this, Observer {
            Log.i(TAG, it.toString())
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}