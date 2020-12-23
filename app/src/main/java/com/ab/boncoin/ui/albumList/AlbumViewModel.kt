package com.ab.boncoin.ui.albumList

import androidx.lifecycle.MutableLiveData
import com.ab.boncoin.base.BaseViewModel
import com.ab.boncoin.model.Album

/**
 * Created by Aya Boussaadia on 17,December,2020
 */

class AlbumViewModel:BaseViewModel() {
    private val albumId = MutableLiveData<String>()
    private val albumImage = MutableLiveData<String>()

    fun bind(album: Album){
        albumId.value = "Album " + album.id
        albumImage.value = album.thumbnailUrl
    }

    fun getAlbumId():MutableLiveData<String>{
        return albumId
    }

    fun getAlbumImage():MutableLiveData<String>{
        return albumImage
    }
}