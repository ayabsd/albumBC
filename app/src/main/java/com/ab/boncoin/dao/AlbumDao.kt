package com.ab.boncoin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ab.boncoin.model.Photo

/**
 * Created by Aya Boussaadia on 17,December,2020
 */


@Dao
interface AlbumDao {
    @get:Query("SELECT * FROM albums")
    val all: List<Photo>

    @Insert
    fun insertAll(vararg photo: Photo)
}