package net.amazingdomain.sample.myapplication.ui.landing

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.ui.landing.model.AlbumUiModel


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtName: TextView = itemView.findViewById(R.id.txt_name)
    private val imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)

    fun setData(album: AlbumUiModel) {

        txtName.text = album.niceName
        setImage(imageUrl = album.thumbnail,
                placeholderRes = R.mipmap.ic_launcher,
                imageView = imgAvatar)
    }

    private fun setImage(imageUrl: String, @DrawableRes placeholderRes: Int, imageView: ImageView) {
        try {

            Picasso
                    .get()
                    .load(imageUrl)
                    .error(placeholderRes)
                    .placeholder(placeholderRes)
                    .fit()
                    .centerCrop()
                    .into(imgAvatar)
        } catch (e: IllegalArgumentException) {

            Picasso
                    .get()
                    .load(placeholderRes)
                    .fit()
                    .centerCrop()
                    .into(imageView)
        }

    }
}
