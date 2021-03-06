package com.example.asd_ass5_shop.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.asd_ass5_shop.R
import com.example.asd_ass5_shop.databinding.FragmentPayBinding


class PayFragment : Fragment() {
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

   var binding = FragmentPayBinding.inflate(layoutInflater)

       var imgs = ArrayList<Int>()
       imgs.add(R.drawable.pypal)
       imgs.add(R.drawable.visa)
       imgs.add(R.drawable.master_card)

       binding.viewPager.clipToPadding = false
       binding.viewPager.clipChildren = false
       binding.viewPager.currentItem = Math.round((imgs.size / 2).toDouble()).toInt()
       binding.viewPager.offscreenPageLimit = 3
       binding.viewPager.pageMargin = 70
       binding.viewPager.setPageTransformer(false, object : ViewPager.PageTransformer {
           override fun transformPage(page: View, position: Float) {
               var r = 1 - Math.abs(position)
               page.scaleY = .85f + r * .12f

               page.overScrollMode = RecyclerView.OVER_SCROLL_NEVER

           }
       })


       /////////////////////
       return binding.root
   }


}