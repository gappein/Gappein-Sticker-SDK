package com.gappein.sticker.model

import android.content.Context
import android.graphics.*
import android.text.StaticLayout
import android.text.TextPaint
import androidx.core.content.res.ResourcesCompat
import com.gappein.sticker.R

/**
 * Created by Himanshu Singh on 10/4/20.
 */
data class DrawingValues(
    val context: Context,
    val paint: Paint,
    val text: TextValues,
    val isMultiline: Boolean,
    val bitmap: Bitmap
) {

    val defaultPosition: DrawingValues.() -> Unit = {
        val canvas = Canvas(bitmap)
        val textWidth = canvas.width - text.padding
        val textLayout = StaticLayout(
            text.text, TextPaint(paint), textWidth, text.alignment, 1f, 0f, false
        )
        val bounds = Rect().apply {
            if (isMultiline) {
                top = 0
                left = 0
                right = textWidth
                bottom = textLayout.height
            } else {
                paint.setTypeface(ResourcesCompat.getFont(context, R.font.bumper))
                paint.color = Color.BLACK
                paint.style = Paint.Style.FILL
                paint.textSize = 20F
                paint.getTextBounds(text.text, 0, text.text.length, this)
            }
        }

        val x = (bitmap.width - bounds.width()) / 2f
        val y = (bitmap.height - bounds.height()) / 2f

        if (!isMultiline) {
            canvas.drawText(text.text, x, y, paint)
        } else {
            canvas.save()
            canvas.translate(x, y)
            textLayout.draw(canvas)
            canvas.restore()
        }
    }

    fun draw(adjustmentBody: DrawingValues.() -> Unit): Bitmap {
        this.adjustmentBody()
        return bitmap
    }

    companion object {

        private  val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        fun default(context: Context) = DrawingValues(
            context = context,
            paint = paint,
            text = TextValues(""),
            isMultiline = false,
            bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
        )
    }
}