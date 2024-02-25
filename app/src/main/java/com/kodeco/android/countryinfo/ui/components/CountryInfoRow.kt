package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun CountryInfoRow(countryName: String, capitalName: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 15.dp
            )
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color(0xFFE8EAF6))

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Name: $countryName",
                Modifier.padding(
                    top = 5.dp
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Capital: $capitalName",
                Modifier.padding(
                    bottom = 5.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryInfoRowPreview() {
    MyApplicationTheme { CountryInfoRow("France", "Paris") }
}
