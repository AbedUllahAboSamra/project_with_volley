package com.example.asd_ass5_shop.`class`

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class myApp() : Application() {

    var mRequestQueue: RequestQueue? = null

    companion object{
        val url ="https://saree3.net/api/user/products"


        private var mInstanse: myApp? = null

        fun getInstance(): myApp? {
            return mInstanse
        }

    }
    override fun onCreate() {
        mInstanse = this
        super.onCreate()
    }
    private fun getRequestQueue(): RequestQueue? {

        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(applicationContext)
        }
        return mRequestQueue
    }


    fun <T> addtoRequstQueue(req: Request<T>, tag: String) {
        req.tag = tag
        getRequestQueue()!!.add(req)
    }



}