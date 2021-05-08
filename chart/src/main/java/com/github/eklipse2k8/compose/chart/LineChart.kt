package com.github.eklipse2k8.compose.chart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart as MpLineChart

@Composable
fun LineChart(modifier: Modifier = Modifier, content: @Composable ChartDataScope.() -> Unit) {



  AndroidView(
      factory = { MpLineChart(it) },
      modifier = modifier,
      update = { ChartDataScopeImpl(it).content() })
}

@Preview(widthDp = 300, heightDp = 400)
@Composable
fun SimpleLineChart() {
  LineChart(modifier = Modifier.fillMaxSize()) { LineChartDataSet() }
}
