package com.earlyedu.kids.data

import com.earlyedu.kids.model.*

object ContentCatalog {

    val topics: List<TopicCategory> = listOf(
        // ==================== ENGLISH ====================
        TopicCategory(
            id = "eng_phonics_lkg",
            subject = SubjectType.ENGLISH,
            nameEng = "Phonics & ABC Songs",
            nameHindi = "वर्णमाला और फोनिक्स गीत",
            gradeLevel = GradeLevel.LKG,
            videos = listOf(
                VideoContent(
                    id = "v_phonics_1",
                    titleEng = "ABC Phonics Song for Kids",
                    titleHindi = "बच्चों के लिए एबीसी फोनिक्स गीत",
                    youtubeVideoId = "BELlZKpi1Zs",
                    descriptionEng = "Learn the sounds of letters A to Z with fun animations.",
                    descriptionHindi = "मजेदार एनिमेशन के साथ A से Z तक अक्षरों की ध्वनियाँ सीखें।",
                    duration = "3:45",
                    gradeLevel = GradeLevel.LKG
                ),
                VideoContent(
                    id = "v_alphabet_story",
                    titleEng = "Animated Alphabet Story: A to Z",
                    titleHindi = "एनिमेशन वर्णमाला कहानी",
                    youtubeVideoId = "36IBDpTRVjM",
                    descriptionEng = "Cute story helping kids remember alphabet letters and words.",
                    descriptionHindi = "बच्चों को अक्षर और शब्द याद रखने में मदद करने वाली प्यारी कहानी।",
                    duration = "5:12",
                    gradeLevel = GradeLevel.LKG
                )
            )
        ),
        TopicCategory(
            id = "eng_stories_ukg",
            subject = SubjectType.ENGLISH,
            nameEng = "Moral Animated Stories",
            nameHindi = "नैतिक शिक्षा की एनीमेशन कहानियाँ",
            gradeLevel = GradeLevel.UKG,
            videos = listOf(
                VideoContent(
                    id = "v_story_tortoise",
                    titleEng = "The Tortoise and the Hare",
                    titleHindi = "कछुआ और खरगोश की कहानी",
                    youtubeVideoId = "gftT33_I-P8",
                    descriptionEng = "Classic tale about perseverance and steady hard work.",
                    descriptionHindi = "मेहनत और निरंतरता सिखाने वाली प्रसिद्ध बाल कहानी।",
                    duration = "4:30",
                    gradeLevel = GradeLevel.UKG
                ),
                VideoContent(
                    id = "v_story_thirsty_crow",
                    titleEng = "The Thirsty Crow Animated Story",
                    titleHindi = "प्यास कौआ - सचित्र कहानी",
                    youtubeVideoId = "37R_O1i052A",
                    descriptionEng = "Smart crow uses stones to drink water. Teaches problem solving.",
                    descriptionHindi = "बुद्धिमान कौआ अपनी समस्या हल करता है।",
                    duration = "3:20",
                    gradeLevel = GradeLevel.UKG
                )
            )
        ),
        TopicCategory(
            id = "eng_grammar_c1",
            subject = SubjectType.ENGLISH,
            nameEng = "Simple Words & Sentences",
            nameHindi = "सरल शब्द और वाक्य बनाना",
            gradeLevel = GradeLevel.CLASS_1,
            videos = listOf(
                VideoContent(
                    id = "v_sight_words",
                    titleEng = "Top 50 Sight Words for Class 1",
                    titleHindi = "कक्षा 1 के लिए 50 मुख्य शब्द",
                    youtubeVideoId = "gIZjrcG9pWw",
                    descriptionEng = "Interactive animation to boost reading fluency for Class 1.",
                    descriptionHindi = "पढ़ने की गति और समझ बढ़ाने के लिए एनीमेशन।",
                    duration = "6:15",
                    gradeLevel = GradeLevel.CLASS_1
                )
            )
        ),

        // ==================== MATH ====================
        TopicCategory(
            id = "math_counting_lkg",
            subject = SubjectType.MATH,
            nameEng = "Counting 1 to 20",
            nameHindi = "1 से 20 तक गिनती",
            gradeLevel = GradeLevel.LKG,
            videos = listOf(
                VideoContent(
                    id = "v_count_10",
                    titleEng = "Numbers Song 1 to 10 with Rhymes",
                    titleHindi = "1 से 10 तक संख्या गीत",
                    youtubeVideoId = "ea5-SIe5l7M",
                    descriptionEng = "Catchy visual song to learn counting numbers 1 through 10.",
                    descriptionHindi = "1 से 10 तक गिनती याद करने का मजेदार संगीतमय तरीका।",
                    duration = "3:10",
                    gradeLevel = GradeLevel.LKG
                ),
                VideoContent(
                    id = "v_shapes_basic",
                    titleEng = "Basic Shapes for Kindergarten",
                    titleHindi = "किंडरगार्टन के लिए बुनियादी आकार (Circle, Square)",
                    youtubeVideoId = "OEbRDtA3_qA",
                    descriptionEng = "Learn Circle, Square, Triangle, and Rectangle with friendly animated characters.",
                    descriptionHindi = "वृत्त, वर्ग, त्रिभुज और आयत की एनीमेशन द्वारा पहचान।",
                    duration = "4:00",
                    gradeLevel = GradeLevel.LKG
                )
            )
        ),
        TopicCategory(
            id = "math_addition_ukg",
            subject = SubjectType.MATH,
            nameEng = "Fun Addition & Subtraction",
            nameHindi = "जोड़ और घटाव का जादू",
            gradeLevel = GradeLevel.UKG,
            videos = listOf(
                VideoContent(
                    id = "v_addition_apples",
                    titleEng = "Adding Fruits: Basic Addition for Kids",
                    titleHindi = "फलों को जोड़ें: बुनियादी गणित",
                    youtubeVideoId = "mLTP1t4Xzsg",
                    descriptionEng = "Visual introduction to adding numbers using apples and balloons.",
                    descriptionHindi = "फलों और गुब्बारों के माध्यम से सरल जोड़ सीखें।",
                    duration = "5:00",
                    gradeLevel = GradeLevel.UKG
                )
            )
        ),
        TopicCategory(
            id = "math_class1_concepts",
            subject = SubjectType.MATH,
            nameEng = "Skip Counting & Place Value",
            nameHindi = "इकाई-दहाई और संख्या प्रणाली",
            gradeLevel = GradeLevel.CLASS_1,
            videos = listOf(
                VideoContent(
                    id = "v_tens_ones",
                    titleEng = "Tens and Ones Concept for Class 1",
                    titleHindi = "इकाई और दहाई की अवधारणा",
                    youtubeVideoId = "1F3AycEDksY",
                    descriptionEng = "Understand place values with colorful bundle blocks.",
                    descriptionHindi = "रंगीन ब्लॉक की मदद से इकाई और दहाई समझें।",
                    duration = "5:45",
                    gradeLevel = GradeLevel.CLASS_1
                )
            )
        ),

        // ==================== SOCIAL SCIENCE ====================
        TopicCategory(
            id = "soc_family_lkg",
            subject = SubjectType.SOCIAL_SCIENCE,
            nameEng = "My Family & Myself",
            nameHindi = "मेरा परिवार और मैं",
            gradeLevel = GradeLevel.LKG,
            videos = listOf(
                VideoContent(
                    id = "v_family_finger",
                    titleEng = "Family Members Rhyme",
                    titleHindi = "परिवार के सदस्य - सचित्र गीत",
                    youtubeVideoId = "YJiEVaN_S_Y",
                    descriptionEng = "Identify Father, Mother, Brother, Sister and Baby with animation.",
                    descriptionHindi = "माता, पिता, भाई, बहन और दादा-दादी को पहचानें।",
                    duration = "3:30",
                    gradeLevel = GradeLevel.LKG
                )
            )
        ),
        TopicCategory(
            id = "soc_helpers_ukg",
            subject = SubjectType.SOCIAL_SCIENCE,
            nameEng = "Our Community Helpers",
            nameHindi = "हमारे मददगार (Doctor, Teacher, Police)",
            gradeLevel = GradeLevel.UKG,
            videos = listOf(
                VideoContent(
                    id = "v_helpers_song",
                    titleEng = "Who Helps Us? Community Helpers",
                    titleHindi = "हमारी मदद कौन करता है?",
                    youtubeVideoId = "BOvCne1oYdY",
                    descriptionEng = "Animated lesson on Doctors, Firefighters, Teachers, and Farmers.",
                    descriptionHindi = "डॉक्टर, शिक्षक, पुलिस और किसान के कार्यों को जानें।",
                    duration = "4:50",
                    gradeLevel = GradeLevel.UKG
                )
            )
        ),
        TopicCategory(
            id = "soc_env_class1",
            subject = SubjectType.SOCIAL_SCIENCE,
            nameEng = "Clean World & Good Habits",
            nameHindi = "स्वच्छता और अच्छी आदतें",
            gradeLevel = GradeLevel.CLASS_1,
            videos = listOf(
                VideoContent(
                    id = "v_good_habits",
                    titleEng = "Good Manners and Healthy Habits",
                    titleHindi = "अच्छी आदतें और शिष्टाचार",
                    youtubeVideoId = "d3LPrhI0v-w",
                    descriptionEng = "Learn brushing, washing hands, saying Please and Thank You.",
                    descriptionHindi = "हाथ धोना, सफाई रखना और धन्यवाद बोलना सीखें।",
                    duration = "4:15",
                    gradeLevel = GradeLevel.CLASS_1
                )
            )
        ),

        // ==================== GENERAL KNOWLEDGE ====================
        TopicCategory(
            id = "gk_animals_lkg",
            subject = SubjectType.GENERAL_KNOWLEDGE,
            nameEng = "Animals & Their Sounds",
            nameHindi = "जानवर और उनकी बोलियाँ",
            gradeLevel = GradeLevel.LKG,
            videos = listOf(
                VideoContent(
                    id = "v_animal_sounds",
                    titleEng = "Wild & Farm Animals with Sounds",
                    titleHindi = "पालतू और जंगली जानवर",
                    youtubeVideoId = "t99ULJjC648",
                    descriptionEng = "Hear how Lion roars, Dog barks, and Cow moos with vivid 3D animations.",
                    descriptionHindi = "शेर, गाय और कुत्ते की आवाजें और तस्वीरें देख कर सीखें।",
                    duration = "4:10",
                    gradeLevel = GradeLevel.LKG
                )
            )
        ),
        TopicCategory(
            id = "gk_seasons_ukg",
            subject = SubjectType.GENERAL_KNOWLEDGE,
            nameEng = "Colors, Fruits & Seasons",
            nameHindi = "रंग, फल और मौसम की जानकारी",
            gradeLevel = GradeLevel.UKG,
            videos = listOf(
                VideoContent(
                    id = "v_seasons_learning",
                    titleEng = "Four Seasons Animated Video",
                    titleHindi = "चार मौसम: गर्मी, सर्दी, बारिश और वसंत",
                    youtubeVideoId = "ksGiLaIx39c",
                    descriptionEng = "Summer, Winter, Rainy, and Spring explained simply.",
                    descriptionHindi = "मौसम के बदलाव और उनके कपड़ों के बारे में एनीमेशन।",
                    duration = "5:10",
                    gradeLevel = GradeLevel.UKG
                )
            )
        ),
        TopicCategory(
            id = "gk_body_class1",
            subject = SubjectType.GENERAL_KNOWLEDGE,
            nameEng = "Human Body Parts & Five Senses",
            nameHindi = "शरीर के अंग और पांच ज्ञानेंद्रियां",
            gradeLevel = GradeLevel.CLASS_1,
            videos = listOf(
                VideoContent(
                    id = "v_five_senses",
                    titleEng = "My Body Parts and 5 Senses",
                    titleHindi = "शरीर के अंग और देखने-सुनने की शक्ति",
                    youtubeVideoId = "q1xNuU7gaAQ",
                    descriptionEng = "Eyes to see, Ears to hear, Nose to smell! Fun Class 1 GK lesson.",
                    descriptionHindi = "आँख, कान, नाक, जीभ और त्वचा के कार्य जानें।",
                    duration = "4:40",
                    gradeLevel = GradeLevel.CLASS_1
                )
            )
        )
    )

    fun getTopicsBySubject(subject: SubjectType): List<TopicCategory> {
        return topics.filter { it.subject == subject }
    }
}
