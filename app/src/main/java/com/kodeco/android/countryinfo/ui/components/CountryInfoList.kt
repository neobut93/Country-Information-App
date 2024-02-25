package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO fill out CountryInfoList
@Composable
fun CountryInfoList(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(text = text,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp))
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoListPreview() { }
