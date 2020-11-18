package com.itmo.labtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Card : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_layout2)

        val params = intent.extras;
        val versions = DataStorage.getVersionsList();

        val poster = findViewById<ImageView>(R.id.poster);
        val biopic = findViewById<ImageView>(R.id.biopic);
        val name = findViewById<TextView>(R.id.name);
        val date = findViewById<TextView>(R.id.date);
        val desc = findViewById<TextView>(R.id.desc);
        val btn = findViewById<Button>(R.id.button);

        val data: TileData = versions[params?.getInt("position")!!];
        poster.setImageResource(data.poster);
        biopic.setImageResource(data.imageAndroid);
        name.setText(data.title);
        date.setText(data.relDate);
        desc.setText(data.desc);

        btn.setOnClickListener {
            val openUrl = Intent (Intent.ACTION_VIEW, Uri.parse(data.link));
            startActivity(openUrl);
        }

    }
}