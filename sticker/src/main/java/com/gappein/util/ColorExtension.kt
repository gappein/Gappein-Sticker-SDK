package com.gappein.util

import android.graphics.Color
import java.util.*

fun generateColor(): Int {
    val random = Random()
    return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
}