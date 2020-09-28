package com.arctouch.io.outdoorsychallenge.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.arctouch.io.outdoorsychallenge.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(
    value = ["imageUrl", "placeholder", "error"],
    requireAll = false
)
fun ImageView.loadImage(url: String?, placeholder: Drawable?, error: Drawable?) = Glide
    .with(context)
    .load(url)
    .apply(RequestOptions().centerInside().placeholder(placeholder).error(error))
    .into(this)

@BindingAdapter("goneUnless")
fun View.goneUnless(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("srcFavorite")
fun ImageView.src(isFavorite: Boolean) {
    val resource = if (isFavorite)
        R.drawable.icon_star_selected
    else
        R.drawable.icon_star_unselected
    this.setImageResource(resource)
}