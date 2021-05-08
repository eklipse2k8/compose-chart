package com.github.eklipse2k8.compose.chart

import androidx.compose.runtime.Immutable
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider

@ChartDataScopeMarker
@Immutable
abstract class ChartDataScope {
  internal abstract val dataProvider: BarLineScatterCandleBubbleDataProvider
}

class ChartDataScopeImpl(override val dataProvider: BarLineScatterCandleBubbleDataProvider) :
    ChartDataScope()
