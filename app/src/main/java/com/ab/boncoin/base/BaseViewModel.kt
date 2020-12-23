package com.ab.boncoin.base

import androidx.lifecycle.ViewModel
import com.ab.boncoin.ui.albumList.AlbumListViewModel
import com.ab.boncoin.ui.albumList.AlbumViewModel
import com.ab.boncoin.injection.component.DaggerViewModelInjector
import com.ab.boncoin.injection.component.ViewModelInjector
import com.ab.boncoin.injection.module.NetworkModule

/**
 * Created by Aya Boussaadia on 17,December,2020
 */

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()
    init {

        inject()
    }
    private fun inject() {
        when (this) {
            is AlbumListViewModel -> injector.inject(this)
            is AlbumViewModel -> injector.inject(this)
        }
    }
}