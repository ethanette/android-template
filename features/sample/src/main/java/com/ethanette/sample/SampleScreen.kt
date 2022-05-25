package com.ethanette.sample

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ethanette.component.ScaffoldComponent
import com.ethanette.framework.viewmodel.use
import com.ethanette.theme.EthanetteTheme

/**
 * Sample list screen
 * sample list screen
 *
 * @param modifier
 * @param viewModel
 */
@Composable
fun SampleListScreen(
    modifier: Modifier = Modifier,
    viewModel: SampleViewModel = sampleViewModel()
) {
    val (state, _, _) = use(viewModel)
    val lazyListState = rememberLazyListState()

    ScaffoldComponent(
        modifier = modifier.fillMaxSize(),
        title = {
            Text(text = "Sample List")
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = lazyListState
        ) {
            state.sampleList.forEach {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            }
        }
    }
}

@Preview("light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SampleListScreenPreview() {
    EthanetteTheme {
        Surface {
            SampleListScreen()
        }
    }
}