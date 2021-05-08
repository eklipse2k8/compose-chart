package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.github.eklipse2k8.compose.chart.data.Entry
import com.github.mikephil.charting.data.LineDataSet as MpLineDataSet

@Composable
fun ChartDataScopeImpl.LineChartDataSet(
    label: String? = null,
    dataSetList: List<Entry> = emptyList(),
) {
  val context = LocalContext.current
  val mpDataSet = dataSetList.map { it.toMpEntry(context) }
  val dataSet = remember { MpLineDataSet(mpDataSet, label) }

  dataProvider.data.addDataSet(dataSet)
}
