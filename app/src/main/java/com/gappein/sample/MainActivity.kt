package com.gappein.sample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gappein.sticker.Generator
import com.gappein.sticker.model.TextValues
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val x =  Generator.setText(TextValues(text = "Himanshu")).draw()
        background.setImageBitmap(x)
    }
}