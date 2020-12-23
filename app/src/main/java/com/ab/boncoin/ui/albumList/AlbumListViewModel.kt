package com.ab.boncoin.ui.albumList

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.ab.boncoin.R
import com.ab.boncoin.base.BaseViewModel
import com.ab.boncoin.dao.AlbumDao
import com.ab.boncoin.model.Album
import com.ab.boncoin.model.Photo
import com.ab.boncoin.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Aya Boussaadia on 17,December,2020
 */


class AlbumListViewModel(private val albumDao: AlbumDao):BaseViewModel() {
    @Inject
    lateinit var api: ApiService
    val albumListAdapter: AlbumListAdapter = AlbumListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPhotos() }
    private lateinit var subscription: Disposable

    val isLoading = ObservableBoolean()

    fun onRefresh() {
        isLoading.set(true)
        loadPhotos()
    }

    private fun onReady() = isLoading.set(false)


    private val listener = object: AlbumListAdapter.OnAlbumClickListener {
        override fun onCustomItemClicked(album: Album , view : View) {
           Navigation.findNavController(view).navigate(AlbumListFragmentDirections
               .actionAlbumFragmentToPhotoFragment(album))
        }
    }
    init {
        loadPhotos()
    }
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

     private fun loadPhotos() {
        subscription = Observable.fromCallable { albumDao.all }
            .concatMap { dbPostList ->
                if (dbPostList.isEmpty())
                    api.getAlbums().concatMap { apiPostList ->
                        albumDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveAlbumListStart() }
            .doOnTerminate { onRetrieveAlbumListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrieveAlbumListError() }
            )
    }

    private fun onRetrieveAlbumListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveAlbumListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(photoList: List<Photo>) {
        onReady()
        val albums: MutableMap<String, Album> = mutableMapOf()

        photoList.forEach { photo ->
            if (!albums.containsKey(photo.albumId.toString())) {
                albums[photo.albumId.toString()] =
                    Album(photo.albumId.toString(),photo.thumbnailUrl, mutableListOf())
            }
            val album: Album = albums[photo.albumId.toString()] as Album
            album.photos.add(photo)
        }
        albumListAdapter.updateAlbumList(albums.values.toList())
        albumListAdapter.setListenner(listener)
    }

    private fun onRetrieveAlbumListError() {
         errorMessage.value = R.string.album_error
    }


}