package com.gappein.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View.MeasureSpec
import com.gappein.ui.StickerView

fun StickerView.generateSticker(text: String): Bitmap {
    val view = this
    view.updateText(text)
    view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)

    val width = if (view.measuredWidth == 0) 1 else view.measuredWidth
    val height = if (view.measuredHeight == 0) 1 else view.measuredHeight

    val bitmap = Bitmap.createBitmap(
        width, height,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)

    view.layout(0, 0, width, height)
    view.draw(canvas)
    return bitmap
}
