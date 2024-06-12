package com.moment.hob.android

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.moment.hob.HobRepository
import com.moment.hob.android.ui.navigation.HobBottomNavigationBar
import com.moment.hob.android.ui.navigation.HobNavHost
import com.moment.hob.android.ui.navigation.HobNavigationActions
import com.moment.hob.android.ui.navigation.HobRoute
import com.moment.hob.android.ui.navigation.HobTopLevelDestination
import com.moment.hob.android.ui.navigation.TOP_LEVEL_DESTINATIONS
import com.moment.hob.android.ui.theme.HobTheme
import kotlinx.coroutines.Dispatchers

@Composable
fun HobApp(hobRepository: HobRepository) {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        HobNavigationActions(navController)
    }
    HobTheme {
        Surface {
            HobAppContent(
                navController = navController,
                navigateToTopLevelDestination = navigationActions::navigateTo,
                hobRepository = hobRepository
            )
        }
    }
}

@Composable
fun HobAppContent(
    navController: NavHostController,
    navigateToTopLevelDestination: (HobTopLevelDestination) -> Unit,
    hobRepository: HobRepository
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    var startDestination by remember { mutableStateOf(HobRoute.EXPLORE) }
    LaunchedEffect(Unit, Dispatchers.IO) {
        startDestination = if (hobRepository.checkToken()) HobRoute.EDIT_PROFILE else HobRoute.WELCOME
        Log.d("TAG", "HobAppContent: start desti $startDestination")
    }
    Column {
        HobNavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
            hobRepository = hobRepository,
            startDestination = startDestination
        )
        if (TOP_LEVEL_DESTINATIONS.any { it.route == currentDestination?.route }) {
            HobBottomNavigationBar(
                navController = navController,
                navigateToTopLevelDestination = navigateToTopLevelDestination
            )
        }
    }
}
