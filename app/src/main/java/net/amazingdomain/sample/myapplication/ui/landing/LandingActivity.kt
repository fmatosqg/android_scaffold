package net.amazingdomain.sample.myapplication.ui.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.databinding.ActivityMainBinding


class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        val model = ViewModelProviders.of(this).get(LandingViewModel::class.java)
        binding.viewModel = model

        setSupportActionBar(toolbar)

    }


}
