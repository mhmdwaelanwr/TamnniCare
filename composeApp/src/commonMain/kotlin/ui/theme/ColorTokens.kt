package ui.theme

import androidx.compose.ui.graphics.Color

object ColorTokens {
    // Primary Brand Colors
    val Navy = Color(0xFF0F2144)
    val SoftTeal = Color(0xFF6FD1C6)
    val TealMist = Color(0xFFDDF4F2)
    val WarmWhite = Color(0xFFF9FBFD)

    // Text Colors
    val TextDark = Color(0xFF1A2333)
    val TextMuted = Color(0xFF667085)

    // Semantic States
    val Success = Color(0xFF39A96B)
    val Warning = Color(0xFFF4B740)
    val Error = Color(0xFFD95C5C)
    val Info = Color(0xFF3B82F6)
    val Outline = Color(0xFFD0D7E2)

    // Dark Mode additions to avoid hardcoded hex in AppColors
    val BackgroundDark = Color(0xFF121212)
    val SurfaceDark = Color(0xFF1E1E1E)
    val SurfaceVariantDark = Color(0xFF2C2C2C)
    val ErrorDark = Color(0xFFEF5350)
    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
}
