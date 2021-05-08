package com.github.eklipse2k8.compose.chart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.charts.LineChart as MpLineChart
import com.github.mikephil.charting.data.LineDataSet as MpLineDataSet

interface LineChartDataScope {
  fun addDataSet(dataSet: MpLineDataSet)
}

@Composable
fun LineDataSet(
  label: String
): MpLineDataSet {

  val values = emptyList<Entry>()

  val dataSet = remember {
    MpLineDataSet(values, label)
  }

  return dataSet
}

@Composable
fun LineChart(modifier: Modifier = Modifier, data: LineChartDataScope.() -> Unit): MpLineChart {
  val context = LocalContext.current
  val chart = remember { MpLineChart(context) }

  AndroidView(
      factory = { MpLineChart(it) },
      modifier = modifier,
  )

  Column {

  }

  data(
      object : LineChartDataScope {
        override fun addDataSet(dataSet: MpLineDataSet) {
          chart.data.addDataSet(dataSet)
        }
      })

  return chart
}

@Preview(widthDp = 300, heightDp = 400)
@Composable
fun SimpleLineChart() {
  LineChart(modifier = Modifier.fillMaxSize()) {
    // addDataSet()
  }
}
