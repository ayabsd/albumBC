package com.ab.boncoin.model.AppDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ab.boncoin.dao.AlbumDao
import com.ab.boncoin.model.Photo

/**
 * Created by Aya Boussaadia on 17,December,2020
 */
@Database(entities = [Photo::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): AlbumDao
}