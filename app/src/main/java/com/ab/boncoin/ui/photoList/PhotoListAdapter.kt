package com.ab.boncoin.ui.photoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ab.boncoin.R
import com.ab.boncoin.databinding.ItemPhotoBinding
import com.ab.boncoin.model.Photo

/**
 * Created by Aya Boussaadia on 19,December,2020
 */
class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    private lateinit var photoList: List<Photo>
    private lateinit var listenner: OnPhotoClickListener

    interface OnPhotoClickListener{
        fun onPhotoClicked(album : Photo, view : View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPhotoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_photo,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photoList[position])
        holder.itemView.setOnClickListener {
            listenner.onPhotoClicked(photoList[position] ,holder.itemView)
        }
    }
    override fun getItemCount(): Int {
        return if (::photoList.isInitialized) photoList.size else 0
    }
    fun updatePhotoList(photoList: List<Photo>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }

    fun setListenner(listenner : OnPhotoClickListener) {
        this.listenner = listenner

    }

    class ViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PhotoiewModel()

        fun bind(photo: Photo) {
            viewModel.bind(photo)
            binding.viewModel = viewModel

        }
    }
}