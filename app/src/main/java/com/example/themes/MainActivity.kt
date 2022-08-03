package com.example.themes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
   private lateinit var gridView : GridView
    var modallist = ArrayList<Modal>()

    var names = arrayOf(
        "image1",
        "image2",
        "image3",
        "image4",
        "image5",
        "image6",
        "image7",
        "image8",
        "image9",
        "image10",
        "image11",
        "image12"
    )

    var images = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5,
        R.drawable.image_6,
        R.drawable.image_7,
        R.drawable.image_8,
        R.drawable.image_9,
        R.drawable.image_10,
        R.drawable.image_11,
        R.drawable.image_12
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in names.indices) {
            modallist.add(Modal(names[i], images[i]))
        }
        var customAdapter = CustomAdapter(modallist, this);

        gridView = findViewById(R.id.gridView)
        gridView.adapter = customAdapter;

        gridView.setOnItemClickListener {adapterView,view,i,l ->
          var intent = Intent(this,ViewActivity::class.java)
            intent.putExtra("data",modallist[i])
            startActivity(intent);
        }
    }
        class CustomAdapter(
        var itemModal : ArrayList<Modal>,
        var context : Context
    ): BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
            var view = view;
            if(view == null){
                view=layoutInflater.inflate(R.layout.row_item,viewGroup,false)
            }

            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView)

            tvImageName?.text= itemModal[position].name
            imageView?.setImageResource(itemModal[position].image!!)

            return view !!;
        }

        override fun getItem(p0: Int): Any {
            return itemModal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return itemModal.size
        }

    }
}