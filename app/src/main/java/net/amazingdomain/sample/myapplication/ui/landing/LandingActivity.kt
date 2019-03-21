package net.amazingdomain.sample.myapplication.ui.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.landing_toolbar.*
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LandingActivity : AppCompatActivity() {

    private val viewModel by viewModel<LandingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                .also { it.lifecycleOwner = this }
                .also { it.viewModel = viewModel }

        setSupportActionBar(toolbar)


        swipe.setOnRefreshListener {
            viewModel.fetchData()
        }

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        recycler_view
                .also { it.layoutManager = LinearLayoutManager(this) }
                .also { it.adapter = ListItemAdapter() }
    }

}
