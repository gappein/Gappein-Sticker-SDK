package com.gappein.sticker

/**
 * Created by Himanshu Singh on 10/4/20.
 */

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import com.gappein.sticker.model.DrawingValues
import com.gappein.sticker.model.TextValues

class Generator(private val context: Context) {

    private var values = DrawingValues.default(context)

    fun setPaint(paint: Paint) = apply { values = values.copy(paint = paint) }

    @JvmOverloads
    fun setText(text: TextValues, isMultiline: Boolean = values.isMultiline) = apply {
        values = values.copy(
            text = text,
            isMultiline = isMultiline
        )
    }

    fun setBackground(bitmap: Bitmap) = apply {
        values = values.copy(bitmap = bitmap.copy(bitmap.config, true))
    }

    fun setBackground(drawable: Drawable) = apply {
        val bitmap = drawable.toBitmap(config = Bitmap.Config.ARGB_8888)
        setBackground(bitmap)
    }

    fun draw(adjustmentBody: DrawingValues.() -> Unit = values.defaultPosition): Bitmap {
       return values.draw(adjustmentBody)
    }


}