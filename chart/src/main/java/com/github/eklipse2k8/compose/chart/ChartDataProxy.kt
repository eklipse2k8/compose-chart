package com.github.eklipse2k8.compose.chart

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.interfaces.datasets.IDataSet

internal class ChartDataProxy<T> where T : IDataSet<Entry> {
  private val dataSetStack = mutableListOf<T>()

  fun addDataSet(d: T) {
    dataSetStack.add(d)
  }

  fun removeDataSet(d: T): Boolean = dataSetStack.remove(d)

  @ExperimentalStdlibApi
  fun getDataSetChanges(): List<T> =
    buildList { this.addAll(dataSetStack) }.also { dataSetStack.clear() }
}
