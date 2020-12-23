package com.ab.boncoin.ui.albumList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ab.boncoin.R
import com.ab.boncoin.databinding.ItemAlbumBinding
import com.ab.boncoin.model.Album


/**
 * Created by Aya Boussaadia on 17,December,2020
 */

class AlbumListAdapter : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {
    private lateinit var albumList: List<Album>
    private lateinit var listenner: OnAlbumClickListener

    interface OnAlbumClickListener{
        fun onCustomItemClicked(album : Album , view : View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAlbumBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_album,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position])

        holder.itemView.setOnClickListener {
            listenner.onCustomItemClicked(albumList[position] ,holder.itemView)
        }
    }
    override fun getItemCount(): Int {
        return if (::albumList.isInitialized) albumList.size else 0
    }
    fun updateAlbumList(albumList: List<Album>) {
        this.albumList = albumList
        notifyDataSetChanged()
    }

    fun setListenner(listenner : OnAlbumClickListener) {
        this.listenner = listenner
    }

    class ViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = AlbumViewModel()

        fun bind(album: Album) {
            viewModel.bind(album)
            binding.viewModel = viewModel

        }
    }
}