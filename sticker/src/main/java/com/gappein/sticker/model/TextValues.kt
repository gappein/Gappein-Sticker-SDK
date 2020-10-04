package com.gappein.sticker.model

import android.text.Layout

/**
 * Created by Himanshu Singh on 10/4/20.
 */

data class TextValues(
    /** Text to be displayed */
    val text: String,
    /** Padding in px - not taken in account when not multiline */
    val padding: Int = 0,
    /** Text alignment, defaults to center - not taken in account when not multiline */
    val alignment: Layout.Alignment = Layout.Alignment.ALIGN_CENTER
)