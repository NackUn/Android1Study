package com.khb.searchmovie.model

import java.util.*

data class MovieDetail (
    var title: String,
    var link: String,
    var image: String?,
    var subtitle: String,
    var pubDate: Date,
    var director: String,
    var actor: String,
    var userRating: Int
)