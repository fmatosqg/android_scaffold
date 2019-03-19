package net.amazingdomain.sample.myapplication.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {

    private var listData: List<AlbumUiModel>

    init {
        listData = listOf()
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
                        null
                    }
                }
                .let { holder.setData(it) }

    }

    @UiThread
    fun setData(itemsList: List<AlbumUiModel>?) {

        this.listData = itemsList ?: listOf()
        notifyDataSetChanged()
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val kittyName: TextView = itemView.findViewById(R.id.kitty_name)

        fun setData(album: AlbumUiModel?) {

            kittyName.text = album?.niceName

        }
    }
}

/**
 * Referenced as "app:listData" in layout;
 * Called through the data binding generated code.
 */
@BindingAdapter("listData")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, listData: List<AlbumUiModel>?) {

    with(recyclerView?.adapter) {
        if (this is ListItemAdapter) {
            setData(listData)
        }
    }
}
