package net.amazingdomain.sample.myapplication.ui.landing

import androidx.recyclerview.widget.RecyclerView
import net.amazingdomain.sample.myapplication.databinding.ListItemBinding
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel


class ItemViewHolder(private val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(album: AlbumUiModel) {

        itemBinding.album = album
        itemBinding.executePendingBindings() // do not remove, may affect variable sized rows
    }

}


