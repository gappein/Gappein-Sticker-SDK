package com.gappein.sticker.util

import android.graphics.Color
import android.view.View
import java.util.*

fun View.generateColor(): Int {
    val random = Random()
    return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
}