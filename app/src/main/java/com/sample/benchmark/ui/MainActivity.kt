package com.sample.benchmark.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.semantics {
                    testTagsAsResourceId = true
                }
            ) {
                TopAppBar(title = { Text(text = "Macrobenchmark Sample") })
                ActivityList()
            }
        }
    }

    @Composable
    fun ActivityList() {
        Column {
            TextButton(
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("recyclerView"),
                onClick = {
                    val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
                    startActivity(intent)
                },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("Scroll view")
            }
            TextButton(
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("composeList"),
                onClick = {
                    val intent = Intent(this@MainActivity, ComposeListViewActivity::class.java)
                    startActivity(intent)
                },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("Compose list view")
            }
        }
    }


}
