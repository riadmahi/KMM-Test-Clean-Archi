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
    const val WELCOME = "Welcome"
    const val SIGN_IN = "Signin"
    const val SIGN_UP = "Signup"
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
