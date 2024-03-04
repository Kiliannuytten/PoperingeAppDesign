package be.kiliannuytten.poperinge_screen_designs

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.kiliannuytten.poperinge_screen_designs.ui.screens.CollectionScreen
import be.kiliannuytten.poperinge_screen_designs.ui.screens.DisclaimerScreen
import be.kiliannuytten.poperinge_screen_designs.ui.screens.HandleidingScreen
import be.kiliannuytten.poperinge_screen_designs.ui.screens.InfoScreen
import be.kiliannuytten.poperinge_screen_designs.ui.screens.MapScreen
import be.kiliannuytten.poperinge_screen_designs.ui.screens.MenuScreen
import be.kiliannuytten.poperinge_screen_designs.ui.theme.Achtergrondkleur
import be.kiliannuytten.poperinge_screen_designs.ui.theme.LichtOranje
import be.kiliannuytten.poperinge_screen_designs.ui.theme.Oranje
import be.kiliannuytten.poperinge_screen_designs.ui.viewmodels.CollectionViewModel

enum class PoperingeAppScreens(@StringRes val title: Int) {
    Disclaimer(title = R.string.disclaimer),
    Menu(title = R.string.menu),
    Map(title = R.string.map),
    HandLeiding(title = R.string.handleiding),
    Collection(title = R.string.collection),
    Info(title = R.string.info)
}

@Composable
fun PoperingeApp(
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PoperingeAppScreens.valueOf(
        backStackEntry?.destination?.route ?: PoperingeAppScreens.Disclaimer.name
    )
    // viewmodels
    val collectionViewModel = CollectionViewModel()

    // navbar onderaan
    Scaffold(
        bottomBar = {
            if (currentScreen != PoperingeAppScreens.Disclaimer){
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                        .padding(start = 2.dp, end = 2.dp),
                    //containerColor = LichtOranje,
                    tonalElevation = 2.dp
                ){
                    // Map
                    NavigationBarItem(
                        selected = currentScreen == PoperingeAppScreens.Map,
                        onClick = { navController.navigate(PoperingeAppScreens.Map.name) },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = stringResource(R.string.placemarker),
                                tint = if (currentScreen == PoperingeAppScreens.Map) Oranje else Color.Gray
                            )
                        }
                    )
                    // Menu / home
                    NavigationBarItem(
                        selected = currentScreen == PoperingeAppScreens.Menu,
                        onClick = { navController.navigate(PoperingeAppScreens.Menu.name) },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = stringResource(R.string.menu),
                                tint = if (currentScreen == PoperingeAppScreens.Menu) Oranje else Color.Gray
                            )
                        }
                    )
                    // Collectie
                    NavigationBarItem(
                        selected = currentScreen == PoperingeAppScreens.Collection,
                        onClick = { navController.navigate(PoperingeAppScreens.Collection.name) },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.List,
                                contentDescription = stringResource(R.string.collection),
                                tint = if (currentScreen == PoperingeAppScreens.Collection) Oranje else Color.Gray
                            )
                        }
                    )
                }
            }
        }
    ) {
        innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Achtergrondkleur
        ) {
            NavHost(
                navController = navController,
                startDestination = PoperingeAppScreens.Disclaimer.name,
                modifier = Modifier.padding(innerPadding)
            ){
                //disclaimer
                composable(route = PoperingeAppScreens.Disclaimer.name){
                    DisclaimerScreen (
                        onContinueClicked = {navController.navigate(PoperingeAppScreens.Menu.name)}
                    )
                }
                // menu
                composable(route = PoperingeAppScreens.Menu.name){
                    MenuScreen (
                        onCollectionClick = {navController.navigate(PoperingeAppScreens.Collection.name)},
                        onMapClick = {navController.navigate(PoperingeAppScreens.Map.name)},
                        onHandleidingClick = {navController.navigate(PoperingeAppScreens.HandLeiding.name)}
                    )
                }
                // collecite
                composable(route = PoperingeAppScreens.Collection.name){
                    CollectionScreen(collectionViewmodel = collectionViewModel)
                }
                // info
                composable(route = PoperingeAppScreens.Info.name){
                    InfoScreen()
                }
                // map
                composable(route = PoperingeAppScreens.Map.name){
                    MapScreen()
                }
                // handleiding
                composable(route = PoperingeAppScreens.HandLeiding.name){
                    HandleidingScreen()
                }

            }
        }
    }
}
