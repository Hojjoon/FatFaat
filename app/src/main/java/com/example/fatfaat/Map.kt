package com.example.fatfaat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.fatfaat.R
import kotlinx.android.synthetic.main.map_view.*
import net.daum.mf.map.api.MapView


class Map : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val map = MapView(this)
//        var mapViewContainer = map_view as? ViewGroup
//
//        mapViewContainer?.addView(map)

        setContentView(R.layout.search_on_map)

    }
}