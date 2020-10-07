package com.gappein.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gappein.StickerView
import com.gappein.util.generateSticker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val x = StickerView(this)
        setContentView(R.layout.activity_main)
        background.setImageBitmap(x.generateSticker("Himanshu"))
    }
}