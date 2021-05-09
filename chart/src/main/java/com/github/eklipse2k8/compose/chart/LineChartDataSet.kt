package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.github.eklipse2k8.compose.chart.data.Entry
import com.github.mikephil.charting.data.LineDataSet as MpLineDataSet

@Composable
fun LineChartDataSet(
    label: String? = null,
    dataSetList: List<Entry> = emptyList(),
) {
  val context = LocalContext.current
  val mpDataSet = dataSetList.map { it.toMpEntry(context) }
  val dataSet = remember { MpLineDataSet(mpDataSet, label) }

  // TODO (jarjoura): add in proxy to store dataset, wrap in stateful watching
  // dataProvider.data.addDataSet(dataSet)
}
