package com.example.asd_ass5_shop.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.asd_ass5_shop.databinding.ProductArryDesignBinding
import com.squareup.picasso.Picasso

class mmPagerAdapter(var context: Context, var images: ArrayList<String>) : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {


            var pinding = ProductArryDesignBinding.inflate(LayoutInflater.from(context), null, false)
            Picasso.get().load(images[position]).into(pinding.imageView2)
            container.addView(pinding.root)
            return pinding.root



         }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}