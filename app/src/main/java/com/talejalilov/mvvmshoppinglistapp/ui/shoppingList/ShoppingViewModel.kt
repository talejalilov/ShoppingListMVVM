package com.talejalilov.mvvmshoppinglistapp.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.talejalilov.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.talejalilov.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository:ShoppingRepository) : ViewModel() {
        fun upset(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
            repository.upsert(item)
        }

    fun delete(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() =repository.getAllShoppingItems()
}