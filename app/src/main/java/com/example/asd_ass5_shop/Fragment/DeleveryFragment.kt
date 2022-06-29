package com.example.asd_ass5_shop.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.asd_ass5_shop.databinding.FragmentDeleveryBinding


class DeleveryFragment : Fragment() {
    lateinit var binding: FragmentDeleveryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeleveryBinding.inflate(layoutInflater)

        return binding.root
    }


}