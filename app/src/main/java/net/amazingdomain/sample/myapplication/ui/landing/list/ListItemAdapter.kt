package net.amazingdomain.sample.myapplication.ui.landing.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.databinding.ListItemBinding
import net.amazingdomain.sample.myapplication.ui.common.list.ItemViewHolder

class ListItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var listData: List<String>

    init {
        listData = listOf()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding: ListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                        R.layout.list_item, parent, false)


        val viewHolder = ItemViewHolder(binding)
        binding.lifecycleOwner = viewHolder

        return viewHolder
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

    override fun onViewAttachedToWindow(holder: ItemViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()

    }

    override fun onViewDetachedFromWindow(holder: ItemViewHolder) {
        super.onViewDetachedFromWindow(holder)

        holder.markDetach()
    }

    @UiThread
    fun setData(itemsList: List<String>?) {

        this.listData = itemsList ?: listOf()
        notifyDataSetChanged()
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
