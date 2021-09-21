package io.github.regbl.fetchrewardsjsonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.regbl.fetchrewardsjsonlist.data.Item

class ItemsAdapter() : ListAdapter<Item, ItemsAdapter.ItemViewHolder>(ItemsDiffCallback()) {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var currentItem: Item? = null
        val textViewId: TextView
        val textViewListId: TextView
        val textViewName: TextView

        init {
            textViewId = view.findViewById(R.id.id)
            textViewListId = view.findViewById(R.id.list_id)
            textViewName = view.findViewById(R.id.name)
        }

        fun bind(item: Item) {
            currentItem = item

            textViewName.text = item.name
            textViewListId.text = ("listId: ${item.listId.toString()}")
            textViewId.text = ("id: ${item.id.toString()}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val currentView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(currentView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class ItemsDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}