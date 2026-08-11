package com.earlyedu.kids.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earlyedu.kids.model.Language

@Composable
fun WelcomeScreen(
    currentLanguage: Language,
    onStartClick: () -> Unit
) {
    // ANIMATION STATES
    val infiniteTransition = rememberInfiniteTransition(label = "WelcomeAnimation")

    // Pulsing scale for main icon
    val iconScale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "IconScale"
    )

    // Rotating sparkles
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing)
        ),
        label = "Rotation"
    )

    // Start button bounce animation
    val buttonScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ButtonScale"
    )

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFDE7), // Soft yellow top
            Color(0xFFFFF9C4), // Warm light gold center
            Color(0xFFFFECB3)  # Rich child amber base
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            // TOP HEADER SPARKLES & SUBTITLE
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = "Sparkles",
                        tint = Color(0xFFFF9100),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (currentLanguage == Language.HINDI) "किंडरगार्टन और कक्षा 1 शिक्षा" else "Early Learning • Nursery to Class 1",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE65100),
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = "Sparkles",
                        tint = Color(0xFFFF9100),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // CENTER HERO ANIMATION AND APP NAME
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // ANIMATED HERO EMBLEM
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(160.dp)
                ) {
                    // Outer glowing circle
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFFF6F00).copy(alpha = 0.2f),
                        modifier = Modifier
                            .size(160.dp)
                            .scale(iconScale)
                    ) {}

                    // Middle bright circle
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFFF8F00),
                        shadowElevation = 12.dp,
                        modifier = Modifier.size(120.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = "School Icon",
                                tint = Color.White,
                                modifier = Modifier.size(72.dp)
                            )
                        }
                    }

                    // Floating books/stars around hero icon
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = "Book",
                        tint = Color(0xFF0288D1),
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.TopEnd)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // APP TITLE: BACCHO KI PATHSALA
                Text(
                    text = "Baccho ki Pathsala",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1565C0),
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "बच्चों की पाठशाला",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Interactive Animated Videos, Rhymes & Stories",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            }

            // FOOTER: ANIMATED START BUTTON & "POWERED BY RANJEET THAKUR"
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                // ANIMATED "START LEARNING" BUTTON
                Button(
                    onClick = onStartClick,
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6F00)
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .scale(buttonScale)
                        .height(56.dp)
                        .padding(horizontal = 24.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Start",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (currentLanguage == Language.HINDI) "पढ़ाई शुरू करें" else "Start Learning",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // POWERED BY RANJEET THAKUR CREDIT
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White.copy(alpha = 0.85f),
                    shadowElevation = 2.dp,
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = Color(0xFFFFB300),
                        shape = RoundedCornerShape(16.dp)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Powered by ",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "Ranjeet Thakur",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF1565C0)
                        )
                    }
                }
            }
        }
    }
}
