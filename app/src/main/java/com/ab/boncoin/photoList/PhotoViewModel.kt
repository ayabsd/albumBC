package com.ab.boncoin.photoList

import androidx.lifecycle.MutableLiveData
import com.ab.boncoin.base.BaseViewModel
import com.ab.boncoin.model.Photo

/**
 * Created by Aya Boussaadia on 19,December,2020
 */

class PhotoiewModel: BaseViewModel() {
    private val albumId = MutableLiveData<String>()
    private val albumImage = MutableLiveData<String>()


    fun bind(photo: Photo){
        albumId.value = "Photo " + photo.id
        albumImage.value = photo.thumbnailUrl
    }

    fun getPhotoId(): MutableLiveData<String> {
        return albumId
    }

    fun getPhotoImage(): MutableLiveData<String> {
        return albumImage
    }
}