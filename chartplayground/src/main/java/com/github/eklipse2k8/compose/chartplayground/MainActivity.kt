package com.github.eklipse2k8.compose.chartplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.eklipse2k8.compose.chart.LineChart
import com.github.eklipse2k8.compose.chart.data.Entry
import com.github.eklipse2k8.compose.chartplayground.ui.theme.ComposeChartTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeChartTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
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
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposeChartTheme { LineChart(modifier = Modifier.fillMaxSize()) {} }
}
