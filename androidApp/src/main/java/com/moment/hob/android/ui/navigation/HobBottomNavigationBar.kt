package com.moment.hob.android.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun HobBottomNavigationBar(
    navController: NavController,
    navigateToTopLevelDestination: (HobTopLevelDestination) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.White,
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        TOP_LEVEL_DESTINATIONS.forEach { hobDestination ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.outline,
                    indicatorColor = MaterialTheme.colorScheme.background,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.outline
                ),
                selected = currentRoute == hobDestination.route,
                onClick = {
                    navigateToTopLevelDestination(hobDestination)
                },
                icon = {
                    Icon(
                        painterResource(id = hobDestination.selectedIcon),
                        contentDescription = stringResource(id = hobDestination.iconTextId),
                    )
                },
                label = {
                    Text(text = hobDestination.route, style = MaterialTheme.typography.labelSmall)
                }
            )
        }
    }
}