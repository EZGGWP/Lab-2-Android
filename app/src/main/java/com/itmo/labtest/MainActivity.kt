package com.itmo.labtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, Card::class.java);

        val android = DataStorage.getVersionsList();
        val adapter = Adapter(this, android ) {
            position -> intent.putExtra("position", position);
            startActivity(intent);
        };

        val list = findViewById<RecyclerView>(R.id.androidList);
        list.adapter = adapter;

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.teal_200)!!);
        list.addItemDecoration(decoration)

    }

}