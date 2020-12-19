package com.ab.boncoin.photoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ab.boncoin.R
import com.ab.boncoin.model.Album

class PhotoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_photo_list, container, false)

       val dataString: Album? = PhotoListFragmentArgs.fromBundle(requireArguments()).argFromSenderFragment
        if (dataString != null) {
            print(dataString.id)
        }

        return view
    }

}
