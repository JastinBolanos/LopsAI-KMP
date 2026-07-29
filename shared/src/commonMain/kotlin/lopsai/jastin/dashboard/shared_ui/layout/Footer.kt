package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun Footer(modifier: Modifier = Modifier) {
    val annotatedText = buildAnnotatedString {
        append("By messaging ChatGPT, you agree to our ")

        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Terms")
        }

        append(" and have read our ")

        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Privacy Policy")
        }
        append(".")
    }

    Text(
        text = annotatedText,
        color = TextSecondaryDark,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp, start = 24.dp, end = 24.dp)
    )
}