package com.ab.boncoin.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders


/**
 * Created by Aya Boussaadia on 17,December,2020
 */

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }

}
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: MutableLiveData<String>??) {


        val parentActivity: AppCompatActivity? = imageView.getParentActivity()

        if (parentActivity != null && url != null) {
            val urlGlide = GlideUrl(
                url.value, LazyHeaders.Builder()
                    .addHeader("User-Agent", "your-user-agent")
                    .build()
            )
            GlideApp.with(imageView.context)
                .load(urlGlide)
                .thumbnail(0.1f)

                .into(imageView)

        }
    }

@BindingAdapter("imageUrlFromString")
fun setImageUrlFromString(imageView: ImageView, urlString: String??) {
    val parentActivity: AppCompatActivity? = imageView.getParentActivity()

    if (parentActivity != null && urlString != null) {
        val urlGlide = GlideUrl(
            urlString, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        GlideApp.with(imageView.context)
            .load(urlGlide)
            .thumbnail(0.1f)

            .into(imageView)

    }
}

