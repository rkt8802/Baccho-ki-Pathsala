package com.earlyedu.kids

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.earlyedu.kids.data.ContentCatalog
import com.earlyedu.kids.model.GradeLevel
import com.earlyedu.kids.model.Language
import com.earlyedu.kids.model.SubjectType
import com.earlyedu.kids.ui.components.ParentalGateDialog
import com.earlyedu.kids.ui.screens.*
import com.earlyedu.kids.ui.theme.EarlyEduKidsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable Fullscreen Immersive Mode for Child App Experience
        enableImmersiveMode()

        setContent {
            EarlyEduKidsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BacchoKiPathsalaNavHost()
                }
            }
        }
    }

    private fun enableImmersiveMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                    )
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            enableImmersiveMode()
        }
    }
}

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Home : Screen("home")
    object SubjectDetail : Screen("subject_detail/{subjectId}") {
        fun createRoute(subjectId: String) = "subject_detail/$subjectId"
    }
    object Player : Screen("player/{videoId}") {
        fun createRoute(videoId: String) = "player/$videoId"
    }
    object Settings : Screen("settings")
}

@Composable
fun BacchoKiPathsalaNavHost() {
    val navController = rememberNavController()

    var currentLanguage by remember { mutableStateOf(Language.ENGLISH) }
    var selectedGrade by remember { mutableStateOf(GradeLevel.LKG) }
    var showParentalGate by remember { mutableStateOf(false) }
    var pendingNavigationRoute by remember { mutableStateOf<String?>(null) }

    if (showParentalGate) {
        ParentalGateDialog(
            onDismiss = {
                showParentalGate = false
                pendingNavigationRoute = null
            },
            onSuccess = {
                showParentalGate = false
                pendingNavigationRoute?.let { route ->
                    navController.navigate(route)
                    pendingNavigationRoute = null
                }
            }
        )
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        // EYE-CATCHING ANIMATED WELCOME SCREEN
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                currentLanguage = currentLanguage,
                onStartClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }

        // HOME DASHBOARD
        composable(Screen.Home.route) {
            HomeScreen(
                currentLanguage = currentLanguage,
                selectedGrade = selectedGrade,
                onLanguageToggle = {
                    currentLanguage = if (currentLanguage == Language.ENGLISH) Language.HINDI else Language.ENGLISH
                },
                onGradeSelect = { grade ->
                    selectedGrade = grade
                },
                onSubjectClick = { subject ->
                    navController.navigate(Screen.SubjectDetail.createRoute(subject.id))
                },
                onOpenSettings = {
                    pendingNavigationRoute = Screen.Settings.route
                    showParentalGate = true
                }
            )
        }

        // SUBJECT TOPICS AND VIDEOS SCREEN
        composable(Screen.SubjectDetail.route) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId")
            val subject = SubjectType.values().find { it.id == subjectId } ?: SubjectType.ENGLISH

            SubjectDetailScreen(
                subject = subject,
                currentLanguage = currentLanguage,
                selectedGrade = selectedGrade,
                onBackClick = { navController.popBackStack() },
                onVideoSelect = { video ->
                    navController.navigate(Screen.PlayerScreen.createRoute(video.id))
                }
            )
        }

        // IN-APP SAFE VIDEO PLAYER
        composable(Screen.PlayerScreen.route) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId")
            val video = ContentCatalog.topics
                .flatMap { it.videos }
                .find { it.id == videoId }

            if (video != null) {
                PlayerScreen(
                    video = video,
                    currentLanguage = currentLanguage,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        // PARENTAL SETTINGS SCREEN
        composable(Screen.Settings.route) {
            SettingsScreen(
                currentLanguage = currentLanguage,
                onLanguageToggle = {
                    currentLanguage = if (currentLanguage == Language.ENGLISH) Language.HINDI else Language.ENGLISH
                },
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
