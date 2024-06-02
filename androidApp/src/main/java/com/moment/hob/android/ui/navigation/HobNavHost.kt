package com.moment.hob.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moment.hob.android.ui.chat.ChatScreen
import com.moment.hob.android.ui.explore.ExploreScreen
import com.moment.hob.android.ui.likes.LikesScreen
import com.moment.hob.android.ui.profile.ProfileScreen


@Composable
fun HobNavHost(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HobRoute.CHAT,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HobRoute.EXPLORE) {
            ExploreScreen()
        }

        composable(HobRoute.LIKES) {
            LikesScreen()
        }

        composable(HobRoute.CHAT) {
            ChatScreen()
        }

        composable(HobRoute.PROFILE) {
            ProfileScreen()
        }
    }
}
