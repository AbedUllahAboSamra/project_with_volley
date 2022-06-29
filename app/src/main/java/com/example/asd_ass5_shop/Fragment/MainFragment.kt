package com.example.asd_ass5_shop.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.asd_ass5_shop.R
import com.example.asd_ass5_shop.Screens.SplachActivity
import com.example.asd_ass5_shop.adapters.ProductAdapterHomeF
import com.example.asd_ass5_shop.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //get All Product From Data Base



        var binding = FragmentMainBinding.inflate(layoutInflater)



        // send code  product adapter
        binding.productRecycleView.layoutManager = GridLayoutManager(requireContext(), 2)
        var productAdapter = ProductAdapterHomeF(SplachActivity.productArrayList, requireContext())
        binding.productRecycleView.adapter = productAdapter


        //end send code

        /////////////////////
        //start  pager code

        var imgs = ArrayList<Int>()
        imgs.add(R.drawable.sh1)
        imgs.add(R.drawable.sh2)
        imgs.add(R.drawable.sh3)
        imgs.add(R.drawable.sh4)
        imgs.add(R.drawable.sh5)




        //end  pager code

        /////////////////////



   return binding.root
    }

}