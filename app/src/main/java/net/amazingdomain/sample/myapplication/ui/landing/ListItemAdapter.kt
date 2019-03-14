package net.amazingdomain.sample.myapplication.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.R

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
                .let { ItemViewHolder(it) }

    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.setData("Kitty # $position")
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val kittyName: TextView = itemView.findViewById(R.id.kitty_name)

        fun setData(name: String) {

            kittyName.text = name

        }
    }
}