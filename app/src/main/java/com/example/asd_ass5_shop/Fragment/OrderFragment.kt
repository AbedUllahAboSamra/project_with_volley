package com.example.asd_ass5_shop.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asd_ass5_shop.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentOrderBinding.inflate(layoutInflater)












        return binding.root
    }
}