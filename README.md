# Baccho ki Pathsala (बच्चों की पाठशाला) - Early Learning Android App

**Baccho ki Pathsala (बच्चों की पाठशाला)** is a dedicated, child-safe Android application designed for early childhood education (Kindergarten, LKG, UKG, up to Class 1) featuring curated animated videos, storytelling, phonics, math concepts, social science, and general knowledge.

*Powered by Ranjeet Thakur*

---

## Key Features

1. **Eye-Catching Animated Welcome Screen:**
   * Features glowing animations, pulsing hero school emblem, floating sparkles, and a prominent **"Powered by Ranjeet Thakur"** credit banner.
   * Interactive animated **"Start Learning / पढ़ाई शुरू करें"** button to jump into the educational dashboard.

2. **Age-Appropriate Curriculum (Kindergarten to Class 1):**
   * **Nursery / LKG:** Alphabet phonics, basic 1–10 counting, basic shapes, family, animals.
   * **UKG:** Moral animated stories, basic addition & subtraction, community helpers, seasons.
   * **Class 1:** Sight words & sentences, tens and ones, hygiene & good habits, human body parts & 5 senses.

3. **Core Subjects Covered:**
   * 🔤 **English:** Phonics, animated stories, alphabet songs, sight words.
   * 🔢 **Math:** Counting, shapes, addition, place values.
   * 🌍 **Social Science:** Family, community helpers, environment, good manners.
   * 💡 **General Knowledge:** Animal sounds, seasons, body parts, colors.

4. **Bilingual Support (Hindi & English):**
   * Seamless one-tap toggle between **English** and **Hindi (हिंदी)** for titles, descriptions, subject categories, and navigation.

5. **Child Safety & Strict Sandboxing (No External App/Window Redirects):**
   * **Sandboxed WebView Video Player:** Uses `youtube-nocookie.com` embed iFrame inside an Android WebView.
   * **Intercepted URL Navigation:** All link clicks, popups, and external app intent attempts (`youtube://`, `vnd.youtube:`, `chrome`, `intent://`) are intercepted and suppressed.
   * **No Popups or New Windows:** `onCreateWindow` and window creation are strictly disabled.
   * **Parental Gate:** A math-verification challenge protects settings and prevents children from navigating out of the learning zone.
   * **Fullscreen Immersive Mode:** Automatically hides Android system navigation and status bars.

---

## Technical Architecture

- **App Name:** Baccho ki Pathsala (`com.earlyedu.kids`)
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose with Material3
- **Min SDK:** 24 (Android 7.0+)
- **Target SDK:** 34 (Android 14)
- **Navigation:** Jetpack Compose Navigation (`NavHost`)
- **Video Engine:** Sandboxed `WebView` with YouTube iFrame Player API

---

## How to Build & Run

1. **Open in Android Studio:**
   * Open Android Studio (Hedgehog or newer recommended).
   * Select **Open an existing project** and navigate to the `EarlyEduKidsApp` folder.

2. **Sync Project with Gradle Files:**
   * Let Gradle download required Jetpack Compose dependencies.

3. **Run on Emulator / Physical Device:**
   * Connect an Android device (Android 7.0+) or start an Android Virtual Device (AVD).
   * Click **Run (Shift + F10)**.
