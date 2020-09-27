package bjfu.it.liuchangxin.starbuzz.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageFromUri")
fun bindImageFromUri(view: ImageView, imageUri: Int) {
    view.setImageResource(imageUri)
}

@BindingAdapter("show")
fun bindShow(view: View, exist: Boolean) {
    view.visibility =
        if (exist)
            View.VISIBLE
        else
            View.GONE
}