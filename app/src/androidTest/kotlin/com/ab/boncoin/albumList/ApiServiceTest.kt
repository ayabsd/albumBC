package com.ab.boncoin.albumList

import com.ab.boncoin.network.ApiService
import com.ab.boncoin.utils.BASE_URL
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Aya Boussaadia on 21,December,2020
 */
class ApiServiceTest {

    lateinit var service: ApiService

    @Before
    internal fun setUp() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)
    }

    @Test
    internal fun should_callServiceWithRx() {
        service.getAlbums().subscribe { repos ->
            repos.forEach(::println)
        }
    }


}