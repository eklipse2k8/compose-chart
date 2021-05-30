package com.github.eklipse2k8.compose.chart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.eklipse2k8.compose.chart.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.charts.LineChart as MpLineChart
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun LineChart(modifier: Modifier = Modifier, content: ChartDataScope.() -> Unit) {
  val chartDataEntriesState = rememberStateOfEntriesProvider(content)

  AndroidView(
      factory = ::MpLineChart,
      modifier = modifier,
      update = { lineChart ->
        val entries = chartDataEntriesState.value.proxy.getDataSetChanges()

        val dataSets = entries.map { dataSet ->
          val lineDataSet = dataSet.entries.map { entry -> entry.toMpEntry(lineChart.context) }
          LineDataSet(lineDataSet, dataSet.label)
        }

        lineChart.data = LineData(dataSets)
      })
}

@Composable
private fun rememberStateOfEntriesProvider(
    content: ChartDataScope.() -> Unit
): State<ChartDataEntriesProvider> {
  val latestContent = rememberUpdatedState(content)
  return remember { derivedStateOf { ChartDataScopeImpl().apply { latestContent.value(this) } } }
}

@Preview(widthDp = 300, heightDp = 400)
@Composable
fun SimpleLineChart() {
  Column {
    LineChart(modifier = Modifier.fillMaxSize()) {
      dataSet {
        listOf(
          Entry(x = 10F, y = 10F),
          Entry(x = 20F, y = 20F),
          Entry(x = 30F, y = 30F),
        )
      }
    }
  }
}
