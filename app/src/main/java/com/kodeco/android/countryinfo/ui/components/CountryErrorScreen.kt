package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun CountryErrorScreen() {
        Column{
            AlertDialog(
                onDismissRequest = {
                    //todo
                },
                title = {
                    Text(text = "Error")
                },
                text = {
                    Text("This is the error")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            //todo
                        }) {
                        Text("Confirm Button")
                    }
                }
            )
        }
    }


@Preview
@Composable
fun CountryErrorScreenPreview() {
    MyApplicationTheme {
        CountryErrorScreen()
    }
}
