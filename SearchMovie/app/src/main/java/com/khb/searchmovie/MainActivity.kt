package com.khb.searchmovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton.setOnClickListener {
            if (searchEditText.text.toString() == "") Toast.makeText(this, "검색어를 입력해주세요", Toast.LENGTH_SHORT).show()
            else {
                Intent(this, MovieActivity::class.java)
                    .putExtra("keyword", searchEditText.text.toString())
                    .let { startActivity(it) }
                
                searchEditText.setText("")
            }
        }
    }
}