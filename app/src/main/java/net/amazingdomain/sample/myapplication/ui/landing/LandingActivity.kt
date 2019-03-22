package net.amazingdomain.sample.myapplication.ui.landing

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.content.res.Configuration
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
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

        swipe.setOnRefreshListener {
            viewModel.fetchData()
        }

        setupRecyclerView()

    }

    override fun onResume() {
        super.onResume()

        btn_glow.animate()

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        val visiblePosition =
                recycler_view.layoutManager
                        .let { it as? LinearLayoutManager }
                        .let { it?.findFirstCompletelyVisibleItemPosition() ?: 0 }

        recycler_view.layoutManager = buildLayoutManager(newConfig?.orientation)

        recycler_view.scrollToPosition(visiblePosition)
    }

    private fun buildLayoutManager(orientation: Int?): RecyclerView.LayoutManager {

        return when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> GridLayoutManager(this, 2)
            else -> LinearLayoutManager(this)
        }

    }

    private fun setupRecyclerView() {

        recycler_view
                .also { it.layoutManager = buildLayoutManager(resources.configuration.orientation) }
                .also { it.adapter = ListItemAdapter() }
    }


}
