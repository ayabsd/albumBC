package com.ab.boncoin.injection.component

import com.ab.boncoin.albumList.AlbumListViewModel
import com.ab.boncoin.albumList.AlbumViewModel
import com.ab.boncoin.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Aya Boussaadia on 17,December,2020
 */

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(albumListViewModel: AlbumListViewModel)
    fun inject(albumViewModel: AlbumViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}