package com.github.eklipse2k8.compose.chart.data

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import com.github.mikephil.charting.data.Entry as MpEntry

@Immutable
data class Entry(
    /** the x-value for the Entry */
    val x: Float = 0f,
    /** the y-value for the Entry */
    val y: Float = 0f,
    /** optional icon image */
    val icon: ImageBitmap? = null,
    /** additional data this Entry should represent */
    val data: Any? = null,
) {
  internal fun toMpEntry(context: Context): MpEntry {
    val drawable = icon?.let { BitmapDrawable(context.resources, it.asAndroidBitmap()) }
    return MpEntry(x, y, drawable, data)
  }
}
