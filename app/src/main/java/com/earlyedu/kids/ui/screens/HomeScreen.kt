package com.earlyedu.kids.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earlyedu.kids.model.GradeLevel
import com.earlyedu.kids.model.Language
import com.earlyedu.kids.model.SubjectType

@Composable
fun HomeScreen(
    currentLanguage: Language,
    selectedGrade: GradeLevel,
    onLanguageToggle: () -> Unit,
    onGradeSelect: (GradeLevel) -> Unit,
    onSubjectClick: (SubjectType) -> Unit,
    onOpenSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFDE7)) // Soft warm yellow background
            .padding(16.dp)
    ) {
        // TOP APP BAR WITH BACCHO KI PATHSALA TITLE AND CONTROLS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFF9100),
                    modifier = Modifier.size(48.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = "Baccho ki Pathsala Logo",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = if (currentLanguage == Language.HINDI) "बच्चों की पाठशाला" else "Baccho ki Pathsala",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1565C0)
                    )
                    Text(
                        text = if (currentLanguage == Language.HINDI) "किंडरगार्टन और कक्षा 1" else "Kindergarten & Class 1",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Row {
                // Language Toggle (English <-> Hindi)
                Button(
                    onClick = onLanguageToggle,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688)),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Translate,
                        contentDescription = "Language",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = currentLanguage.displayName,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Parental Gate Button
                IconButton(
                    onClick = onOpenSettings,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFE0E0E0))
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Parental Controls",
                        tint = Color.DarkGray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // GRADE LEVEL FILTER SELECTION
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GradeLevel.values().forEach { level ->
                val isSelected = level == selectedGrade
                val btnColor = if (isSelected) Color(0xFFFF6F00) else Color.White
                val txtColor = if (isSelected) Color.White else Color.DarkGray

                ElevatedButton(
                    onClick = { onGradeSelect(level) },
                    colors = ButtonDefaults.buttonColors(containerColor = btnColor),
                    shape = RoundedCornerShape(20.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = if (isSelected) 6.dp else 2.dp)
                ) {
                    Text(
                        text = if (currentLanguage == Language.HINDI) level.labelHindi else level.labelEng,
                        fontSize = 14.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = txtColor
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SUBJECT CARDS GRID
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(SubjectType.values()) { subject ->
                SubjectCard(
                    subject = subject,
                    currentLanguage = currentLanguage,
                    onClick = { onSubjectClick(subject) }
                )
            }
        }
    }
}

@Composable
fun SubjectCard(
    subject: SubjectType,
    currentLanguage: Language,
    onClick: () -> Unit
) {
    val title = if (currentLanguage == Language.HINDI) subject.titleHindi else subject.titleEng
    val cardColor = Color(subject.colorHex)

    val icon: ImageVector = when (subject) {
        SubjectType.ENGLISH -> Icons.Default.MenuBook
        SubjectType.MATH -> Icons.Default.Calculate
        SubjectType.SOCIAL_SCIENCE -> Icons.Default.Public
        SubjectType.GENERAL_KNOWLEDGE -> Icons.Default.Lightbulb
    }

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.3f),
                modifier = Modifier.size(56.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
