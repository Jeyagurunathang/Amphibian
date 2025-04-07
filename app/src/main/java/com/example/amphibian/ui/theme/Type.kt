package com.example.amphibian.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amphibian.R

val nunito = FontFamily(
    Font(resId = R.font.nunito)
)

// Set of Material typography styles to start with
val Typography = Typography(
    // Headline fonts for title's
    headlineLarge = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),

    // Body fonts for tag and description
    bodyMedium = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 52.sp
    ),
    bodySmall = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
)