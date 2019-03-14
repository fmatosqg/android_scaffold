package net.amazingdomain.sample.myapplication.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.R

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {

    private var listData: List<String>

    init {
        listData = listOf<String>()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
                .let { ItemViewHolder(it) }

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        listData
                .let {
                    if (position < it.size) {
                        it[position]
                    } else {
                        ""
                    }
                }
                .let { holder.setData(it) }

    }

    @UiThread
    fun setData(itemsList: List<String>?) {

        this.listData = itemsList ?: listOf()
        notifyDataSetChanged()
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val kittyName: TextView = itemView.findViewById(R.id.kitty_name)

        fun setData(name: String) {

            kittyName.text = name

        }
    }
}

/**
 * Referenced as "app:listData" in layout;
 * Called through the data binding generated code.
 */
@BindingAdapter("listData")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, listData: List<String>?) {

    with(recyclerView?.adapter) {
        if (this is ListItemAdapter) {
            setData(listData)
        }
    }
}
