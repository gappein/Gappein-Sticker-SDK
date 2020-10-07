package com.gappein.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.gappein.R
import com.gappein.util.generateColor

class StickerView(context: Context) : AppCompatTextView(context) {

    companion object {
        private const val DEFAULT_STROKE = 4f
        private const val DEFAULT_TEXT_SIZE = 40f
        private const val DEFAULT_TEXT = " "
        private const val STROKE_WIDTH: Float = 10.toFloat()
        private const val STROKE_COLOR: Int = Color.WHITE
    }

    private var _isDrawing: Boolean = false
    private val _shadowColors: ColorStateList = ColorStateList.valueOf(Color.GRAY)
    private val _typeFace = ResourcesCompat.getFont(this.context, R.font.bumper)
    private val _color = generateColor()

    init {
        initResources()
    }

    private fun updateShadowColor() {
        setShadowLayer(
            DEFAULT_STROKE,
            DEFAULT_STROKE,
            DEFAULT_STROKE,
            _shadowColors.getColorForState(drawableState, 0)
        )
    }


    private fun initResources() {
        typeface = _typeFace
        textSize = DEFAULT_TEXT_SIZE
        setTextColor(_color)
        textAlignment = TEXT_ALIGNMENT_CENTER
        text = DEFAULT_TEXT
        updateShadowColor()
    }

    fun updateText(text: String) {
        if (text.contains(DEFAULT_TEXT)) {
            val splitString = text.split(DEFAULT_TEXT, limit = 2)
            val firstString = splitString.first()
            val lastString = splitString.last()
            val displayText =firstString + "\n" + lastString
            setText(displayText)
        } else {
            setText(text)
        }
    }


    override fun invalidate() {
        if (_isDrawing) return
        super.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        if (STROKE_WIDTH > 0) {
            _isDrawing = true
            val textPaint = paint

            textPaint.style = Paint.Style.FILL

            super.onDraw(canvas)

            val currentTextColor = currentTextColor
            textPaint.apply {
                style = Paint.Style.STROKE
                strokeWidth = STROKE_WIDTH
            }
            setTextColor(STROKE_COLOR)
            super.onDraw(canvas)
            setTextColor(currentTextColor)
            _isDrawing = false
        } else {
            super.onDraw(canvas)
        }
    }
}