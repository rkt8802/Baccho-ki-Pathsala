package com.earlyedu.kids.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earlyedu.kids.data.ContentCatalog
import com.earlyedu.kids.model.*

@Composable
fun SubjectDetailScreen(
    subject: SubjectType,
    currentLanguage: Language,
    selectedGrade: GradeLevel,
    onBackClick: () -> Unit,
    onVideoSelect: (VideoContent) -> Unit
) {
    val subjectTitle = if (currentLanguage == Language.HINDI) subject.titleHindi else subject.titleEng
    val subjectColor = Color(subject.colorHex)

    val topics = ContentCatalog.getTopicsBySubject(subject)
        .filter { it.gradeLevel == selectedGrade || it.videos.any { v -> v.gradeLevel == selectedGrade } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFDE7))
    ) {
        // HEADER BAR WITH BACK BUTTON
        Surface(
            color = subjectColor,
            shadowElevation = 6.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.3f), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = subjectTitle,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
        }

        // TOPICS & ANIMATED VIDEO LIST
        if (topics.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (currentLanguage == Language.HINDI) "इस श्रेणी में सामग्री जल्द आ रही है!" else "Videos loading for this grade...",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                topics.forEach { category ->
                    item {
                        Text(
                            text = if (currentLanguage == Language.HINDI) category.nameHindi else category.nameEng,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = subjectColor,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    items(category.videos) { video ->
                        VideoCard(
                            video = video,
                            subjectColor = subjectColor,
                            currentLanguage = currentLanguage,
                            onPlay = { onVideoSelect(video) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VideoCard(
    video: VideoContent,
    subjectColor: Color,
    currentLanguage: Language,
    onPlay: () -> Unit
) {
    val title = if (currentLanguage == Language.HINDI) video.titleHindi else video.titleEng
    val desc = if (currentLanguage == Language.HINDI) video.descriptionHindi else video.descriptionEng

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPlay() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = subjectColor,
                modifier = Modifier.size(52.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = desc,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = "Duration",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = video.duration,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
