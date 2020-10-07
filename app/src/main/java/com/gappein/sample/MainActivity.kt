package com.gappein.sample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gappein.StickerView
import com.gappein.util.generateSticker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextInput.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val x = StickerView(this@MainActivity)
                background.setImageBitmap(x.generateSticker(s.toString()))

            }


            override fun afterTextChanged(s: Editable?) {
               if (s.toString().length<10){
               }
            }

        })
    }


}