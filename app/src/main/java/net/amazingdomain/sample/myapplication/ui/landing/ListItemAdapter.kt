package net.amazingdomain.sample.myapplication.ui.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel

class ListItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

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
                .let { listData[position] }
                .let { holder.setData(it) }

    }

    @UiThread
    fun setData(itemsList: List<AlbumUiModel>) {

        this.listData = itemsList
        notifyDataSetChanged()
    }


}

/**
 * Referenced as "app:listData" in layout;
 * Called through the data binding generated code.
 */
@BindingAdapter("listData")
fun setRecyclerViewProperties(recyclerView: RecyclerView?, listData: List<AlbumUiModel>?) {

    // note that we need to accept an empty listData because of an interesting quirk in live data

    with(recyclerView?.adapter) {
        if (this is ListItemAdapter) {
            setData(listData ?: listOf())
        }
    }
}
