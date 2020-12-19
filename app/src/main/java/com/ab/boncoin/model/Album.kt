package com.ab.boncoin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Aya Boussaadia on 18,December,2020
 */
@Parcelize
data class Album (
   val id: String,
   val thumbnailUrl: String,
   val photos: MutableList<Photo>

) :Parcelable
