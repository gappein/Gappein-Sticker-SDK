package com.gappein.sample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.gappein.Sticker
import com.gappein.ui.StickerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stickerView = StickerView(this)

        editTextInput.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length < 20) {
                    background.setImageBitmap(
                        Sticker.with(this@MainActivity, s.toString())
                    )
                }
            }

        })
    }


}