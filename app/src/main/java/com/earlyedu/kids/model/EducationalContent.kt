package com.earlyedu.kids.model

enum class Language(val code: String, val displayName: String) {
    ENGLISH("en", "English"),
    HINDI("hi", "हिंदी")
}

enum class GradeLevel(val code: String, val labelEng: String, val labelHindi: String) {
    LKG("lkg", "Nursery / LKG", "नर्सरी / एल.के.जी."),
    UKG("ukg", "UKG / Kindergarten", "यू.के.जी. / के.जी."),
    CLASS_1("class1", "Class 1", "कक्षा 1")
}

enum class SubjectType(
    val id: String,
    val titleEng: String,
    val titleHindi: String,
    val iconName: String,
    val colorHex: Long
) {
    ENGLISH("english", "English Fun", "अंग्रेजी शिक्षा", "menu_book", 0xFFFF6F00), // Amber
    MATH("math", "Math & Numbers", "गणित और संख्याएँ", "calculate", 0xFF0288D1), // Light Blue
    SOCIAL_SCIENCE("social_science", "Our World", "सामाजिक ज्ञान", "public", 0xFF388E3C), // Green
    GENERAL_KNOWLEDGE("gk", "General Knowledge", "सामान्य ज्ञान", "lightbulb", 0xFF7B1FA2) // Purple
}

data class VideoContent(
    val id: String,
    val titleEng: String,
    val titleHindi: String,
    val youtubeVideoId: String, // YouTube Video ID for embedded HTML5 player
    val descriptionEng: String,
    val descriptionHindi: String,
    val duration: String,
    val gradeLevel: GradeLevel
)

data class TopicCategory(
    val id: String,
    val subject: SubjectType,
    val nameEng: String,
    val nameHindi: String,
    val gradeLevel: GradeLevel,
    val videos: List<VideoContent>
)
