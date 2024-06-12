package com.moment.hob.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moment.hob.HobRepository
import com.moment.hob.android.ui.chat.ChatScreen
import com.moment.hob.android.ui.explore.ExploreScreen
import com.moment.hob.android.ui.likes.LikesScreen
import com.moment.hob.android.ui.profile.ProfileScreen
import com.moment.hob.android.ui.profile.ProfileViewModel
import com.moment.hob.android.ui.settings.EditProfileScreen
import com.moment.hob.android.ui.settings.EditProfileViewModel
import com.moment.hob.android.ui.settings.about.EditDisplayNameScreen
import com.moment.hob.android.ui.signin.SignInScreen
import com.moment.hob.android.ui.signin.SignInViewModel
import com.moment.hob.android.ui.signup.SignUpScreen
import com.moment.hob.android.ui.welcome.WelcomeScreen


@Composable
fun HobNavHost(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HobRoute.WELCOME,
    hobRepository: HobRepository
) {
    val editProfileViewModel = EditProfileViewModel(hobRepository)
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HobRoute.WELCOME) {
            WelcomeScreen(
                navigateToSignIn = { navController.navigate(HobRoute.SIGN_IN) },
                navigateToSignUp = { navController.navigate(HobRoute.SIGN_UP) }
            )
        }

        composable(HobRoute.SIGN_IN) {
            SignInScreen(
                viewModel = SignInViewModel(hobRepository),
                navigateBack = { navController.popBackStack() },
                navigateToExplore = {
                    navController.navigate(HobRoute.EXPLORE) {
                        popUpTo(HobRoute.WELCOME) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(HobRoute.SIGN_UP) {
            SignUpScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

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
            ProfileScreen(
                viewModel = ProfileViewModel(hobRepository),
                navigateToEditProfile = { navController.navigate(HobRoute.EDIT_PROFILE) }
            )
        }

        composable(HobRoute.EDIT_PROFILE) {
            EditProfileScreen(
                viewModel = editProfileViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToEditName = {
                    navController.navigate(HobRoute.EDIT_PROFILE_NAME)
                }
            )
        }

        composable(HobRoute.EDIT_PROFILE_NAME) {
            EditDisplayNameScreen(
                viewModel = editProfileViewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
