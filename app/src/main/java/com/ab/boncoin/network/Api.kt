package com.ab.boncoin.network

import com.ab.boncoin.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Aya Boussaadia on 17,December,2020
 */

interface Api {
    /**
     * Get the list of the pots from the API
     */
    @GET("/img/shared/technical-test.json")
    fun getAlbums(): Observable<List<Photo>>
}