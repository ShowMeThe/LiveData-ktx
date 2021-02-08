package com.show.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import com.show.livedataktx.debounce
import com.show.livedataktx.filter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = MutableLiveData<String>()


        findViewById<Button>(R.id.btn).setOnClickListener {
            data.value = "4500"
        }



        data.debounce(300)
                .filter { it!=null }
                .observe(this){
                    Log.e("MainActivity", it)
                }

    }
}