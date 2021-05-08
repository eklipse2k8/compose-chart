package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.neverEqualPolicy
import com.github.mikephil.charting.charts.LineChart

internal val LocalMpLineChart =
    compositionLocalOf<LineChart>(neverEqualPolicy()) {
      error("CompositionLocal LocalLineChart not present")
    }
