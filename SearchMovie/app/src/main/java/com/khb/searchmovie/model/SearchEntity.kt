package com.khb.searchmovie.model

import com.google.gson.annotations.SerializedName

class SearchEntity {
    @SerializedName("items")
    var items: List<MovieEntity>? = null
}