package com.example.testapplication.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.R
import com.example.testapplication.view.adapter.KeyWordAdapter
import com.example.testapplication.viewmodel.KeyWordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var keyWordAdapter: KeyWordAdapter
    private lateinit var viewModel: KeyWordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[KeyWordViewModel::class.java]
        keyWordAdapter = KeyWordAdapter(this)
        keyword_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayout.HORIZONTAL, false
            )
            adapter  = keyWordAdapter
        }

        viewModel.getAllKeyWords().observe(this, Observer<List<String>> { keywords ->
            keyWordAdapter.setAdapter(keywords)
        })

    }
}
