package com.talejalilov.mvvmshoppinglistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.talejalilov.mvvmshoppinglistapp.R
import com.talejalilov.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.talejalilov.mvvmshoppinglistapp.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        val curShoppingItem = items[position]
        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener{
            curShoppingItem.amount++
            viewModel.upset(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {

            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upset(curShoppingItem)
            }
        }




    }

    override fun getItemCount(): Int {
        return items.size

    }
}