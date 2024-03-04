package be.kiliannuytten.poperinge_screen_designs.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import be.kiliannuytten.poperinge_screen_designs.ui.theme.Oranje

@Composable
fun CollectionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dit is de collection screen",
            color = Oranje
        )
    }
}

@Preview
@Composable
fun PreviewCollectionScreen() {
    CollectionScreen()
}
