package com.khb.searchmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khb.searchmovie.model.MovieEntity
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class MovieActivity : AppCompatActivity() {
    private var networkHelper = NetworkHelper()
    private lateinit var setTextView: (ArrayList<MovieEntity>) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movieKeyword = intent.getStringExtra("keyword");
        keywordTextView.text = movieKeyword

        setTextView = { items ->
            var sb = StringBuilder()
            items.map {
                sb.append("영화 이름 : ${it.title}\n")
            }
            resultTextView.text = sb.toString()
        }

        GlobalScope.launch(Dispatchers.IO) {
            networkHelper.requestMovie(movieKeyword, setTextView)
        }
    }
}