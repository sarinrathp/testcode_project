package com.sarinrath.testcode_project.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sarinrath.testcode_project.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    startDestination: String,
    viewModel: MainViewModel
) {
    val navController = rememberNavController()
    val action = remember(navController) {
        AppActions(navController)
    }
    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            AppDestinations.NEWS_ROUTE
        ) {
            NewsComposable(viewModel = viewModel, selectedNews = action.selectedNews)
        }

        composable(
            "${AppDestinations.NEWS_DETAIL_ROUTE}/{${AppDestinations.NEWS_DETAIL_ID_KEY}}",
            arguments = listOf(
                navArgument(AppDestinations.NEWS_DETAIL_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DetailComposable(
                viewModel,
                newsId = arguments.getInt(AppDestinations.NEWS_DETAIL_ID_KEY),
                navigateUp = action.navigateUp
            )
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val selectedNews: (Int) -> Unit = { newsId: Int ->
        navController.navigate("${AppDestinations.NEWS_DETAIL_ROUTE}/$newsId")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}