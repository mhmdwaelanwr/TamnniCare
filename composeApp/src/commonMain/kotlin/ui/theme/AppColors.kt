package ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightColors = lightColorScheme(
    primary = ColorTokens.Navy,
    onPrimary = ColorTokens.White,
    primaryContainer = ColorTokens.TealMist,
    onPrimaryContainer = ColorTokens.TextDark,
    
    secondary = ColorTokens.SoftTeal,
    onSecondary = ColorTokens.Navy,
    secondaryContainer = ColorTokens.TealMist,
    onSecondaryContainer = ColorTokens.TextDark,

    tertiary = ColorTokens.Success,
    onTertiary = ColorTokens.White,
    tertiaryContainer = ColorTokens.Success.copy(alpha = 0.16f),
    onTertiaryContainer = ColorTokens.Success,
    
    background = ColorTokens.WarmWhite,
    onBackground = ColorTokens.TextDark,
    
    surface = ColorTokens.White,
    onSurface = ColorTokens.TextDark,
    surfaceVariant = ColorTokens.TealMist.copy(alpha = 0.42f),
    onSurfaceVariant = ColorTokens.TextMuted,
    
    error = ColorTokens.Error,
    onError = ColorTokens.White
)

val DarkColors = darkColorScheme(
    primary = ColorTokens.SoftTeal,
    onPrimary = ColorTokens.Navy,
    primaryContainer = ColorTokens.Navy,
    onPrimaryContainer = ColorTokens.WarmWhite,
    
    secondary = ColorTokens.SoftTeal,
    onSecondary = ColorTokens.Black,
    secondaryContainer = ColorTokens.Navy,
    onSecondaryContainer = ColorTokens.WarmWhite,

    tertiary = ColorTokens.SoftTeal,
    onTertiary = ColorTokens.Navy,
    tertiaryContainer = ColorTokens.Navy,
    onTertiaryContainer = ColorTokens.SoftTeal,
    
    background = ColorTokens.BackgroundDark,
    onBackground = ColorTokens.WarmWhite,
    
    surface = ColorTokens.SurfaceDark,
    onSurface = ColorTokens.WarmWhite,
    surfaceVariant = ColorTokens.SurfaceVariantDark,
    onSurfaceVariant = ColorTokens.TealMist.copy(alpha = 0.86f),
    
    error = ColorTokens.ErrorDark,
    onError = ColorTokens.Black
)
