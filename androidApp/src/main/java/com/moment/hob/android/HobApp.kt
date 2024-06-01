package com.moment.hob.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.moment.hob.android.ui.navigation.HobBottomNavigationBar
import com.moment.hob.android.ui.navigation.HobNavHost
import com.moment.hob.android.ui.navigation.HobNavigationActions
import com.moment.hob.android.ui.navigation.HobTopLevelDestination
import com.moment.hob.android.ui.theme.HobTheme

@Composable
fun HobApp() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        HobNavigationActions(navController)
    }
    HobTheme {
        Surface {
            HobAppContent(
                navController = navController,
                navigateToTopLevelDestination = navigationActions::navigateTo
            )
        }
    }
}

@Composable
fun HobAppContent(
    navController: NavHostController,
    navigateToTopLevelDestination: (HobTopLevelDestination) -> Unit,
) {
    Column {
        HobNavHost(modifier = Modifier.weight(1f), navController = navController)
        HobBottomNavigationBar(
            navController = navController,
            navigateToTopLevelDestination = navigateToTopLevelDestination
        )
    }
}
