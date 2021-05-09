package com.github.eklipse2k8.compose.chart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart as MpLineChart

@ExperimentalStdlibApi
@Composable
fun LineChart(modifier: Modifier = Modifier, content: ChartDataScope.() -> Unit) {
  val chartDataEntriesState = rememberStateOfEntriesProvider(content)

  AndroidView(
      factory = ::MpLineChart,
      modifier = modifier,
      update = {
        chartDataEntriesState.value.proxy.getDataSetChanges()
        // it.data.addDataSet()
        // ChartDataScopeImpl(it).content()
      })
}

@Composable
private fun rememberStateOfEntriesProvider(
    content: ChartDataScope.() -> Unit
): State<ChartDataEntriesProvider> {
  val latestContent = rememberUpdatedState(content)
  return remember { derivedStateOf { ChartDataScopeImpl().apply(latestContent.value) } }
}

@ExperimentalStdlibApi
@Preview(widthDp = 300, heightDp = 400)
@Composable
fun SimpleLineChart() {
  Column {
    LineChart(modifier = Modifier.fillMaxSize()) {
      dataSet { LineChartDataSet() }
      dataSet { LineChartDataSet() }
      dataSet { LineChartDataSet() }
    }
  }
}
