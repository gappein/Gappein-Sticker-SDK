package com.gappein

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.gappein.sticker.util.generateColor

class StickerView(context: Context) : AppCompatTextView(context) {

    companion object {
        private const val DEFAULT_STROKE = 4f
        private const val DEFAULT_TEXT_SIZE = 60f
        private const val mStrokeWidth: Float = 10.toFloat()
        private const val strokeColor: Int = Color.WHITE
    }

    private var isDrawing: Boolean = false
    private val mShadowColors: ColorStateList = ColorStateList.valueOf(Color.GRAY)
    private val typeFace = ResourcesCompat.getFont(this.context, R.font.bumper)

    init {
        initResources()
    }

    private fun updateShadowColor() {
        setShadowLayer(
            DEFAULT_STROKE,
            DEFAULT_STROKE,
            DEFAULT_STROKE,
            mShadowColors.getColorForState(drawableState, 0)
        )
    }


    private fun initResources() {
        typeface = typeFace
        textSize = DEFAULT_TEXT_SIZE
        setTextColor(generateColor())
        updateShadowColor()
    }

    fun updateText(text: String) {
        setText(text)
    }

    override fun invalidate() {
        if (isDrawing) return
        super.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        if (mStrokeWidth > 0) {
            isDrawing = true
            val textPaint = paint

            textPaint.style = Paint.Style.FILL

            super.onDraw(canvas)

            val currentTextColor = currentTextColor
            textPaint.apply {
                style = Paint.Style.STROKE
                strokeWidth = mStrokeWidth
            }
            setTextColor(strokeColor)
            super.onDraw(canvas)
            setTextColor(currentTextColor)
            isDrawing = false
        } else {
            super.onDraw(canvas)
        }
    }

}