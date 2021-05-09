package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.*
import com.github.eklipse2k8.compose.chart.data.Entry

@ChartDataScopeMarker
@Stable
interface ChartDataEntryScope {
  fun addEntries(entries: List<Entry>)
}

@ChartDataScopeMarker
@Stable
interface ChartDataScope {
  fun dataSet(key: Any? = null, content: @Composable ChartDataEntryScope.() -> Unit)
}

internal class ChartDataScopeImpl() : ChartDataScope, ChartDataEntriesProvider {
  override fun dataSet(key: Any?, content: ChartDataEntryScope.() -> Unit) {}
}

interface ChartDataEntriesProvider {}
