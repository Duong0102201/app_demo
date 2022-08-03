package com.example.themes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class ViewActivity : AppCompatActivity() {

    private lateinit var viewName : TextView
    private lateinit var viewImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        viewName = findViewById(R.id.viewName)
        viewImage = findViewById(R.id.viewImage)

        var modalItem:Modal = intent.getSerializableExtra("data") as Modal;

        modalItem.name?.let { Log.e("name", it) }

        viewName.text = modalItem.name;
        viewImage.setImageResource(modalItem.image!!);
    }
}