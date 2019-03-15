package net.amazingdomain.sample.myapplication.ui.landing.list

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(viewBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewBinding.root), LifecycleOwner {

    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    override fun getLifecycle(): Lifecycle {

        return lifecycleRegistry
    }

    fun markAttach() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)

    }

    fun markDetach() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)

    }

}