package com.talejalilov.mvvmshoppinglistapp.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.talejalilov.mvvmshoppinglistapp.R
import com.talejalilov.mvvmshoppinglistapp.data.db.ShoppingDatabase
import com.talejalilov.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.talejalilov.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import com.talejalilov.mvvmshoppinglistapp.other.ShoppingAdapter
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(applicationContext)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(),viewModel)
        rvShoppingItem.layoutManager = LinearLayoutManager(this)
        rvShoppingItem.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener{
            AddShoppingItemDialog(this,
                object : AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upset(item)
                    }

                }).show()
        }

    }
}