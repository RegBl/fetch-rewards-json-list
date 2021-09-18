package io.github.regbl.fetchrewardsjsonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.regbl.fetchrewardsjsonlist.data.Item

class ItemsAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView
        val textViewListId: TextView
        val textViewName: TextView

        init {
            textViewId = view.findViewById(R.id.id)
            textViewListId = view.findViewById(R.id.list_id)
            textViewName = view.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textViewName.text = items[position].name
        holder.textViewListId.text = items[position].listId.toString()
        holder.textViewId.text = items[position].id.toString()
    }

    override fun getItemCount(): Int = items.size
}