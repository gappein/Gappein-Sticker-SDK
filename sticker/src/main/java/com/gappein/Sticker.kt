package com.gappein

import android.content.Context
import android.graphics.Bitmap
import com.gappein.ui.StickerView
import com.gappein.util.generateSticker

object Sticker {

    fun with(context: Context, text:String):Bitmap = StickerView(context).generateSticker(text)

}