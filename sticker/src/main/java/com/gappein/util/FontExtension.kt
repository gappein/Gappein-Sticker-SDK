package com.gappein.util

import android.graphics.Typeface
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.gappein.R

fun View.getFont(): Typeface? {
    return when ((0..3).random()) {
        0 -> ResourcesCompat.getFont(this.context, R.font.bumper)
        1 -> ResourcesCompat.getFont(this.context, R.font.beibeh)
        2 -> ResourcesCompat.getFont(this.context, R.font.countryside)
        3 -> ResourcesCompat.getFont(this.context, R.font.jennie)
        else -> ResourcesCompat.getFont(this.context, R.font.bumper)
    }
}