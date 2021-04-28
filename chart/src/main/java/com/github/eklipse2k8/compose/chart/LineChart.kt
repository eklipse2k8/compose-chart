package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.github.mikephil.charting.charts.LineChart as MpLineChart
import com.github.mikephil.charting.data.LineDataSet

interface LineChartDataScope {
  fun addDataSet(dataSet: LineDataSet)
}

@Composable
fun LineChart(data: LineChartDataScope.() -> Unit): MpLineChart {
  val context = LocalContext.current
  val chart = remember { MpLineChart(context) }

  // chart.data.dataSets.add()

  return chart
}

@Preview
@Composable
fun SimpleLineChart() {
  LineChart {
    //addDataSet()
  }
}
