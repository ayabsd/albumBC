package com.ab.boncoin.ui.photoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ab.boncoin.databinding.FragmentPhotoDetailsBinding
import com.ab.boncoin.model.Photo


class PhotoDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPhotoDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            com.ab.boncoin.R.layout.fragment_photo_details,
            container,
            false
        )
        val dataPhoto: Photo = PhotoDetailsFragmentArgs.fromBundle(requireArguments()).argFromSenderFragment
        if (dataPhoto != null) binding.photo = dataPhoto

        return binding.root
    }

}