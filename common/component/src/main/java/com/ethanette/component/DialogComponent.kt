package com.ethanette.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ethanette.theme.EthanetteTheme

/**
 * # DialogComponent
 * dialog component
 *
 * @param modifier DialogComponent modifier
 * @param contentPadding dialog padding
 * @param title dialog title area
 * @param content dialog content area
 * @param content confirm click event
 * @param content cancel dismiss event
 */
@Composable
fun DialogComponent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 40.dp),
    title: @Composable () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
    onDismissRequest: () -> Unit,
    onClickConfirm: (() -> Unit)? = null,
    onClickCancel: (() -> Unit)? = null,
) {
    AlertDialog(
        modifier = modifier.padding(contentPadding),
        onDismissRequest = onDismissRequest,
        title = title,
        text = {
            Column(modifier = Modifier.padding(top = 15.dp)) {
                content()
            }
        },
        confirmButton = {
            if (onClickConfirm != null) {
                TextButton(
                    onClick = onClickConfirm
                ) {
                    Text(stringResource(android.R.string.ok))
                }
            }
        },
        dismissButton = {
            if (onClickCancel != null) {
                TextButton(
                    onClick = onClickCancel
                ) {
                    Text(stringResource(android.R.string.cancel))
                }
            }
        }
    )
}

@Preview("light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DialogComponentPreview() {
    EthanetteTheme {
        Surface {
            DialogComponent(
                onDismissRequest = {},
                title = { Text(text = "title") },
                content = { Text(text = "content") },
                onClickConfirm = {},
                onClickCancel = {}
            )
        }
    }
}