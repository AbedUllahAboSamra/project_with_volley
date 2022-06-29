package com.example.asd_ass5_shop.Screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.asd_ass5_shop.MainActivity
import com.example.asd_ass5_shop.R
import com.example.asd_ass5_shop.`class`.myApp
import com.example.asd_ass5_shop.classs.modle.productModle
import com.example.asd_ass5_shop.db.MyDataBase

class SplachActivity : AppCompatActivity() {

    companion object {
        var categoryArray = ArrayList<String>()
        var productArrayList = ArrayList<productModle>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)


        // product Request

        var productRequest = JsonObjectRequest(
            Request.Method.GET,
            "${myApp.url}",
            null,
            { response ->
                var aaa = response.getJSONObject("data")
                var arr = aaa.getJSONArray("products")



                for (i in 0 until arr.length()) {
                    var ob = arr.getJSONObject(i)

                    var images = ob.getJSONArray("images")

                    var arrimages = ArrayList<String>()

                    for (p in 0 until images.length()) {
                        arrimages.add(images.getString(p))
                    }

                    productArrayList.add(
                        productModle(
                            id = ob.getInt("id"),
                            name = ob.getString("name"),
                            name_ar = ob.getString("name_ar"),
                            name_en = ob.getString("name_en"),
                            description = ob.getString("description"),
                            description_ar = ob.getString("description_ar"),
                            description_en = ob.getString("description_en"),
                            price = ob.getDouble("price"),
                            offer = ob.getDouble("offer"),
                            quantity = ob.getDouble("quantity"),
                            rate_sum = ob.getDouble("rate_sum"),
                            rate_count = ob.getDouble("rate_count"),
                            rate = ob.getDouble("rate"),
                            company_id = ob.getInt("company_id"),
                            currency = ob.getString("currency"),
                            preparation_time = ob.getString("preparation_time"),
                            category = ob.getString("category"),
                            company = ob.getString("company"),
                            in_favorite = ob.getBoolean("in_favorite"),
                            image = ob.getString("image"),
                            images = arrimages,
                        )
                    )


                }
                Handler().postDelayed(
                    {
                        var i = Intent(this,MainActivity::class.java)
                        startActivity(i)
                    }, 3000
                )

            },
            { error ->

            })

        myApp.getInstance()!!.addtoRequstQueue(productRequest, "asd")


        MyDataBase(this).getAllProductInBag()


    }
}