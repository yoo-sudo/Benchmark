package com.sample.benchmark.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.sample.benchmark.data.Content

class ComposeListViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = List(100) {
            Content("Item $it")
        }
        setContent {
            BenchmarkComposeList(data)
        }
    }

    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @Composable
    private fun BenchmarkComposeList(data: List<Content>) {
        MaterialTheme {
            Box(modifier = Modifier.semantics {
                // Allows to use testTag() for UiAutomator's resource-id.
                // It can be enabled high in the compose hierarchy,
                // so that it's enabled for the whole subtree
                testTagsAsResourceId = true
            }) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    TopAppBar(title = { Text(text = "Compose List") })

                    LazyColumn(
                        modifier = Modifier.testTag("myLazyColumn")
                    ) {
                        items(data, key = { it.contents }) { item ->
                            EntryRow(content = item,
                                Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        AlertDialog
                                            .Builder(this@ComposeListViewActivity)
                                            .setMessage("Item clicked")
                                            .show()
                                    })
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun EntryRow(content: Content, modifier: Modifier = Modifier) {
        Card(modifier = modifier) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = content.contents, modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize()
                )

                Spacer(modifier = Modifier.weight(1f))

                Checkbox(
                    checked = false, onCheckedChange = {}, modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}