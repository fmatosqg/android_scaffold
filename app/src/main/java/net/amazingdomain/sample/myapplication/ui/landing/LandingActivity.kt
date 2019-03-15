package net.amazingdomain.sample.myapplication.ui.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.landing_toolbar.*
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.databinding.ActivityMainBinding
import net.amazingdomain.sample.myapplication.ui.landing.list.ListItemAdapter
import org.koin.android.ext.android.inject


class LandingActivity : AppCompatActivity() {

    private val viewModel: LandingViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setSupportActionBar(toolbar)

        viewModel.fetchData()

        swipe.setOnRefreshListener {
            viewModel.fetchData()
        }

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ListItemAdapter()
    }


}

