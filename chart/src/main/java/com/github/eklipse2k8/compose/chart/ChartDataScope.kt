package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.*
import com.github.eklipse2k8.compose.chart.data.Entry

@ChartDataScopeMarker @Stable interface ChartDataEntryScope

@ChartDataScopeMarker
@Stable
interface ChartDataScope {
  fun dataSet(label: String = "", entries: ChartDataEntryScope.() -> List<Entry>)
}

internal class ChartDataScopeImpl : ChartDataScope, ChartDataEntriesProvider {
  private val scope = object : ChartDataEntryScope {}

  override val proxy = ChartDataProxy<List<Entry>>()

  override fun dataSet(label: String, entries: ChartDataEntryScope.() -> List<Entry>) {
    proxy.addDataSet(label, entries(scope))
  }
}

internal interface ChartDataEntriesProvider {
  val proxy: ChartDataProxy<List<Entry>>
}
