package be.kiliannuytten.poperinge_screen_designs.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.kiliannuytten.poperinge_screen_designs.data.models.Spook
import be.kiliannuytten.poperinge_screen_designs.ui.viewmodels.CollectionViewModel
import be.kiliannuytten.poperinge_screen_designs.R
import be.kiliannuytten.poperinge_screen_designs.ui.theme.Achtergrondkleur
import be.kiliannuytten.poperinge_screen_designs.ui.theme.LichtOranje


@Composable
fun CollectionScreen(
    collectionViewmodel: CollectionViewModel,
    onSpookClick: () -> Unit = {}
) {
    val spoken = collectionViewmodel.spoken

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(spoken) { spook ->
            SpookCard(
                spook = spook,
                onSpookClick = { collectionViewmodel.updateSpookState(spook); onSpookClick() }, // De CollectionViewModel wordt bijgewerkt voordat de click-handler wordt aangeroepen
                collectionViewmodel = collectionViewmodel
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpookCard(
    spook: Spook,
    onSpookClick: () -> Unit = {},
    collectionViewmodel: CollectionViewModel,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            collectionViewmodel.updateSpookState(spook)
            onSpookClick()
                  },
        colors = CardDefaults.cardColors(
            containerColor = LichtOranje,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mario_boo),
                contentDescription = spook.naam,
                modifier = Modifier
                    .size(125.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = spook.naam,
                color = Achtergrondkleur,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}


@Preview
@Composable
fun PreviewCollectionScreen() {
    CollectionScreen(collectionViewmodel = CollectionViewModel())
}
