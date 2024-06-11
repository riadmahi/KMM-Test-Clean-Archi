package com.moment.hob.android.ui.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.moment.hob.android.R

object HobRoute {
    const val EXPLORE = "explore"
    const val LIKES = "likes"
    const val CHAT = "chat"
    const val PROFILE = "profile"
    const val WELCOME = "welcome"
    const val SIGN_IN = "signin"
    const val SIGN_UP = "signup"
    const val EDIT_PROFILE = "edit_profile"
}

data class HobTopLevelDestination(
    val route: String,
    @DrawableRes val icon: Int,
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
        icon = R.drawable.ic_explore,
        iconTextId = R.string.tab_explore
    ),
    HobTopLevelDestination(
        route = HobRoute.LIKES,
        icon = R.drawable.ic_likes,
        iconTextId = R.string.tab_likes
    ),
    HobTopLevelDestination(
        route = HobRoute.CHAT,
        icon = R.drawable.ic_chat,
        iconTextId = R.string.tab_chat
    ),
    HobTopLevelDestination(
        route = HobRoute.PROFILE,
        icon = R.drawable.ic_profile,
        iconTextId = R.string.tab_profile
    )
)
