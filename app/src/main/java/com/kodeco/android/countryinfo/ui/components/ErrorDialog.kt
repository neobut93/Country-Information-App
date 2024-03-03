package com.kodeco.android.countryinfo.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.R
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun ErrorDialog(
    closeApp: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            // do nothing here, because there is no other UI on screen
        },
        confirmButton = {
            TextButton(
                onClick = {
                    closeApp()
                }) {
                Text(text = stringResource(R.string.close_the_app_alert_button_text))
            }
        },
        title = {
            Text(text = stringResource(R.string.error_alert_title))
        },
        text = {
            Text(stringResource(R.string.error_alert_message))
        }
    )
}

@Preview
@Composable
fun ErrorDialogPreview() {
    MyApplicationTheme {
        CountryErrorScreen()
    }
}