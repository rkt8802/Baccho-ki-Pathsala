package com.earlyedu.kids.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earlyedu.kids.model.Language

@Composable
fun SettingsScreen(
    currentLanguage: Language,
    onLanguageToggle: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // TOP APP BAR
        Surface(
            color = Color(0xFF1976D2),
            shadowElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Parent Control & App Settings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // LANGUAGE PREFERENCE CARD
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Translate,
                            contentDescription = "Language",
                            tint = Color(0xFF1976D2)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Default Language / भाषा चुनें",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Current: ${currentLanguage.displayName}",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Button(onClick = onLanguageToggle) {
                            Text("Switch to ${if (currentLanguage == Language.ENGLISH) "हिंदी" else "English"}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // KIOSK / APP PINNING GUIDANCE CARD
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = "Lock Mode",
                            tint = Color(0xFF2E7D32)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Kid-Safe Kiosk Mode (App Pinning)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "To completely prevent your child from exiting this app, opening YouTube, or opening Chrome browser:",
                        fontSize = 13.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    val instructions = listOf(
                        "1. Go to Android Settings -> Security -> Advanced -> App Pinning.",
                        "2. Turn ON App Pinning and require Device PIN/Pattern to unpin.",
                        "3. Open this app, swipe up to recent apps view, tap the app icon and select 'Pin'.",
                        "4. Your child will be locked strictly inside this early learning app!"
                    )

                    instructions.forEach { step ->
                        Text(
                            text = step,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF2E7D32),
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SAFETY SUMMARY CARD
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Sandboxing",
                            tint = Color(0xFFE65100)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Built-in Content Safety",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "• Embedded video player blocks all popup links.\n" +
                                "• YouTube app/browser launch requests are suppressed.\n" +
                                "• Math Parental Gate protects settings and exit routes.\n" +
                                "• Content curated strictly for Nursery, LKG, UKG & Class 1.",
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}
