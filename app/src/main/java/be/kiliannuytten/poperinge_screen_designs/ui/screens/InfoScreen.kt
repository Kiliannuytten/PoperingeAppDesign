import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.kiliannuytten.poperinge_screen_designs.ui.theme.Oranje
import be.kiliannuytten.poperinge_screen_designs.ui.viewmodels.CollectionViewModel
import be.kiliannuytten.poperinge_screen_designs.data.models.Spook
import be.kiliannuytten.poperinge_screen_designs.R

@Composable
fun InfoScreen(
    collectionViewmodel: CollectionViewModel,
) {
    val spook = collectionViewmodel.getSpook()
    if (spook == null) {
        Text(text = "Spook is null")
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Oranje)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mario_boo),
                    contentDescription = "Foto van het spook",
                    modifier = Modifier.size(200.dp)
                )
            }

            Divider(
                color = Color.Black,
                thickness = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Text(
                text = "${spook?.naam}",
                color = Oranje,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "${spook?.beschrijving}",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewInfoScreen() {
    InfoScreen(collectionViewmodel = CollectionViewModel())
}
