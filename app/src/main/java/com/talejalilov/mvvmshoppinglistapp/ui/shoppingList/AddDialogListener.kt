package com.talejalilov.mvvmshoppinglistapp.ui.shoppingList

import com.talejalilov.mvvmshoppinglistapp.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}