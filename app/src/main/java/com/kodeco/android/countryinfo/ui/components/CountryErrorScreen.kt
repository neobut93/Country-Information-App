package com.kodeco.android.countryinfo.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun CountryErrorScreen() {
    val activity = (LocalContext.current as? Activity)
    ErrorDialog(closeApp = { activity?.finish() })
}

@Preview
@Composable
fun CountryErrorScreenPreview() {
    MyApplicationTheme {
        CountryErrorScreen()
    }
}
