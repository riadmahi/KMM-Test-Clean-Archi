package com.moment.hob.android.ui.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.moment.hob.android.R

object HobRoute {
    const val EXPLORE = "Explore"
    const val LIKES = "Likes"
    const val CHAT = "Chat"
    const val PROFILE = "Profile"
}

data class HobTopLevelDestination(
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val iconTextId: Int
)

class HobNavigationActions(private val navController: NavHostController) {

    fun navigateTo(destination: HobTopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    HobTopLevelDestination(
        route = HobRoute.EXPLORE,
        selectedIcon = R.drawable.ic_explore,
        unselectedIcon = R.drawable.ic_explore_grey,
        iconTextId = R.string.tab_explore
    ),
    HobTopLevelDestination(
        route = HobRoute.LIKES,
        selectedIcon = R.drawable.ic_likes,
        unselectedIcon = R.drawable.ic_likes_grey,
        iconTextId = R.string.tab_likes
    ),
    HobTopLevelDestination(
        route = HobRoute.CHAT,
        selectedIcon = R.drawable.ic_chat,
        unselectedIcon = R.drawable.ic_chat_grey,
        iconTextId = R.string.tab_chat
    ),
    HobTopLevelDestination(
        route = HobRoute.PROFILE,
        selectedIcon = R.drawable.ic_profile,
        unselectedIcon = R.drawable.ic_profile_grey,
        iconTextId = R.string.tab_profile
    )
)
