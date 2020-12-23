package com.ab.boncoin.ui.albumList

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.ab.boncoin.databinding.FragmentAlbumListBinding
import com.ab.boncoin.injection.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


/**
 * Created by Aya Boussaadia on 18,December,2020
 */

class AlbumListFragment : Fragment() {

    private var errorSnackbar: Snackbar? = null
    private lateinit var binding: FragmentAlbumListBinding
    private lateinit var viewModel: AlbumListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            com.ab.boncoin.R.layout.fragment_album_list,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this, ViewModelFactory(activity as AppCompatActivity))
            .get(AlbumListViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        numberOfItemsInRecycle()

        viewModel.errorMessage.observe(viewLifecycleOwner, { errorMessage ->
            if (errorMessage != null) showError(errorMessage)
            else hideError()
        })

        return binding.root
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(com.ab.boncoin.R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }

    private fun numberOfItemsInRecycle() {

        if (this.resources
                .configuration.orientation === Configuration.ORIENTATION_PORTRAIT)
            binding.albumList.layoutManager = GridLayoutManager(activity, 3)
        else
            binding.albumList.layoutManager = GridLayoutManager(activity, 4)

    }


}