package com.ab.boncoin.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Aya Boussaadia on 17,December,2020
 */
@Parcelize
@Entity(tableName = "albums")
data class Photo(
    val albumId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val url : String,
    val thumbnailUrl: String

) :Parcelable