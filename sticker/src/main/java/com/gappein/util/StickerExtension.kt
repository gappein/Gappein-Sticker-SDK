package com.gappein.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View.MeasureSpec
import com.gappein.StickerView

fun StickerView.generateSticker(text:String): Bitmap {
    val view = this
    view.updateText(text)
    view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
    val bitmap = Bitmap.createBitmap(
        view.measuredWidth, view.measuredHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    view.draw(canvas)
    return bitmap
}