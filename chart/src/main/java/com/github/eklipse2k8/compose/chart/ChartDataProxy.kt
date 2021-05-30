package com.github.eklipse2k8.compose.chart

import com.github.eklipse2k8.compose.chart.data.Entry

object ChartStyle {

}

internal data class ChartDataSetContainer<T>(
  val label: String,
  val entries: T,
)

internal class ChartDataProxy<T> where T : List<Entry> {
  private val dataSetStack = mutableListOf<ChartDataSetContainer<T>>()

  fun addDataSet(label: String, d: T) {
    dataSetStack.add(ChartDataSetContainer(label, d))
  }

  fun removeDataSet(d: T): Boolean = dataSetStack.remove(d)

  @OptIn(ExperimentalStdlibApi::class)
  fun getDataSetChanges(): List<ChartDataSetContainer<T>> =
      buildList { this.addAll(dataSetStack) }.also { dataSetStack.clear() }
}
