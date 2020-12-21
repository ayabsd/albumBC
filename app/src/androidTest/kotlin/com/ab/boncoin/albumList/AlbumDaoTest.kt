package com.ab.boncoin.albumList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.ab.boncoin.dao.AlbumDao
import com.ab.boncoin.model.AppDatabase.AppDatabase
import com.ab.boncoin.model.Photo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Aya Boussaadia on 21,December,2020
 */
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class AlbumDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: AppDatabase
    private lateinit var dao: AlbumDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.postDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertPhotoItem() = runBlockingTest {
        val photosItem1 = Photo(
            1,
            1,
            "photo 1",
            "https://via.placeholder.com/600/92c952",
            "https://via.placeholder.com/150/92c952"
        )

        dao.insertAll(photosItem1)
        val allItems = dao.all
        assertThat(allItems).contains(photosItem1)
    }




}
