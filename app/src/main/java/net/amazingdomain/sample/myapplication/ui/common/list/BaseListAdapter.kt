package net.amazingdomain.sample.myapplication.ui.common.list

import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.ui.landing.list.ItemViewHolder

abstract class BaseListAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onViewAttachedToWindow(holder: ItemViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()

    }

    override fun onViewDetachedFromWindow(holder: ItemViewHolder) {
        super.onViewDetachedFromWindow(holder)

        holder.markDetach()
    }
}