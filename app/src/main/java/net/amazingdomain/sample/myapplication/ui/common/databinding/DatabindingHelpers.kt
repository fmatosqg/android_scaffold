package net.amazingdomain.sample.myapplication.ui.common.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import net.amazingdomain.sample.myapplication.R

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView?, imageUrl: String?) {

    val placeholderRes = R.mipmap.ic_launcher

    try {
        Picasso.get()
                .load(imageUrl)
                .error(placeholderRes)
                .placeholder(placeholderRes)
                .fit()
                .centerCrop()
                .into(imageView)
    } catch (e: IllegalArgumentException) {

        Picasso.get()
                .load(placeholderRes)
                .fit()
                .centerCrop()
                .into(imageView)
    }

}
