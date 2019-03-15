package net.amazingdomain.sample.myapplication.ui.common.list

import net.amazingdomain.sample.myapplication.databinding.ListItemBinding
import net.amazingdomain.sample.myapplication.ui.landing.list.BaseViewHolder
import net.amazingdomain.sample.myapplication.ui.landing.list.ItemViewModel

class ItemViewHolder(private val itemViewBinding: ListItemBinding) : BaseViewHolder(itemViewBinding) {

    init {
        // TODO get viewModel from Koin
        itemViewBinding.viewModel = ItemViewModel()
    }

    fun setData(name: String) {

        itemViewBinding.viewModel?.setData(name)

    }


}

