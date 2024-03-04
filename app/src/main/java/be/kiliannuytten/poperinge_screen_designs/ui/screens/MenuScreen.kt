package be.kiliannuytten.poperinge_screen_designs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.kiliannuytten.poperinge_screen_designs.ui.theme.LichtOranje

@Composable
fun MenuScreen(
    onCollectionClick: () -> Unit = {},
    onMapClick: () -> Unit = {},
    onHandleidingClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color(0xFF212121)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LichtOranje,
                )
            ) {
                Button(
                    onClick = { onCollectionClick() },
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LichtOranje
                    )
                ) {
                    Text(
                        text = "Collectie",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LichtOranje,
                )
            ) {
                Button(
                    onClick = { onMapClick() },
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LichtOranje
                    )
                ) {
                    Text(
                        text = "Map",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LichtOranje,
                )
            ) {
                Button(
                    onClick = { onHandleidingClick() },
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LichtOranje
                    )
                ) {
                    Text(
                        text = "Handleiding",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewMenuScreen() {
    MenuScreen()
}
