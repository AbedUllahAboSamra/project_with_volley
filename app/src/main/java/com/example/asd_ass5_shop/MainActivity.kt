package com.example.asd_ass5_shop

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.asd_ass5_shop.Fragment.PaymentFragment
import com.example.asd_ass5_shop.databinding.ActivityMainBinding
import com.example.asd_ass5_shop.databinding.HeaderDrawerBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mytoolbar)
        supportActionBar!!.title = ""



        val togle =
            object : ActionBarDrawerToggle(this, binding.myDrawerlayout, binding.mytoolbar, 0, 0) {

                val scaleFactor = 6f
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    super.onDrawerSlide(drawerView, slideOffset)
                    var slideX = drawerView.width * slideOffset
                    binding.content.setTranslationX(slideX)

                    binding.content.setScaleX(1 - (slideOffset / scaleFactor))
                    binding.content.setScaleY(.99f - (slideOffset / scaleFactor))
                }


            }

        binding.myDrawerlayout.addDrawerListener(togle)
        binding.myDrawerlayout.setScrimColor(Color.TRANSPARENT)
        binding.myDrawerlayout.setDrawerElevation(0f)
        togle.syncState()


        //header click listener
        var headerView = binding.navView.getHeaderView(0)
        var headerBinding = HeaderDrawerBinding.bind(headerView)


        headerBinding.close.setOnClickListener {
            binding.myDrawerlayout.closeDrawer(Gravity.LEFT, true)
        }


        //end code drawer layout


        //******************//


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shopIcon -> {
                supportFragmentManager.beginTransaction().addToBackStack("payment").replace(
                    R.id.Container, PaymentFragment()
                ).commit()

            }

        }


        return super.onOptionsItemSelected(item)
    }


}