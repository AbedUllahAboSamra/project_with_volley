package com.example.asd_ass5_shop.classs.modle

import java.io.Serializable

data class productModle(
    var id: Int,
    var name: String,
    var name_ar: String,
    var name_en: String,
    var description: String,
    var description_en: String,
    var description_ar: String,
    var image: String,
    var price: Double,
    var offer: Double,
    var quantity: Double,
    var currency: String,
    var preparation_time: String,
    var category: String,
    var company: String,
    var company_id: Int,
    var images: ArrayList<String>,
    var rate_sum: Double,
    var rate_count: Double,
    var rate: Double,
    var in_favorite: Boolean

) : Serializable {

}