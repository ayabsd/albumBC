package com.ab.boncoin.photoList

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.ab.boncoin.R
import com.ab.boncoin.model.Album
import com.ab.boncoin.model.Photo
import kotlinx.android.synthetic.main.fragment_photo_list.*

class PhotoListFragment : Fragment(), PhotoListAdapter.OnPhotoClickListener {
    private val photoListAdapter: PhotoListAdapter = PhotoListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()
        getDataFromAlbumListFragment()
    }

    private fun initRecycleView() {
        photo_list.adapter = photoListAdapter
        photoListAdapter.setListenner(this)
        if (this.resources
                .configuration.orientation === Configuration.ORIENTATION_PORTRAIT
        )
            photo_list.layoutManager = GridLayoutManager(activity, 3)
        else
            photo_list.layoutManager = GridLayoutManager(activity, 4)

    }

    private fun getDataFromAlbumListFragment() {
        val dataAlbum: Album? =
            PhotoListFragmentArgs.fromBundle(requireArguments()).argFromSenderFragment
        if (dataAlbum != null) {
            progress.visibility = View.INVISIBLE
            photoListAdapter.updatePhotoList(dataAlbum.photos)
        }
    }

    override fun onPhotoClicked(album: Photo, view: View) {
        Navigation.findNavController(view).navigate(
            PhotoListFragmentDirections
                .actionPhotoListFrafmentToDetailsFragment(album)
        )
    }
}

