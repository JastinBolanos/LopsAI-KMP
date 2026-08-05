package lopsai.jastin.dashboard.features.premium.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.features.premium.data.PremiumPlan

@Composable
fun PlanTierCard(plan: PremiumPlan, isDarkMode: Boolean) {

    // 🎨 Colores de fondo de la tarjeta adaptativos
    val cardBg = if (isDarkMode) Color(0xFF23232D) else Color(0xFFF3F4F6)
    val textColor = if (isDarkMode) Color.White else Color.Black

    val borderModifier = if (plan.isRecommended) {
        Modifier.border(
            width = 2.dp,
            brush = Brush.linearGradient(listOf(Color(0xFFA855F7), Color(0xFFEC4899))),
            shape = RoundedCornerShape(16.dp)
        )
    } else {
        Modifier
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .then(borderModifier)
            .clip(RoundedCornerShape(16.dp))
            .background(cardBg)
            .padding(20.dp)
    ) {
        // --- 1. HEADER (Nombre y Etiqueta Promocional) ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = plan.name,
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            if (plan.badgeText != null) {
                PromoBadge(text = plan.badgeText)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- 2. PRECIO ---
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = plan.price,
                color = textColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = plan.period,
                color = if (isDarkMode) Color.Gray else Color.DarkGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 4.dp, start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- 3. LISTA DE BENEFICIOS ---
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            plan.features.forEach { feature ->
                PlanBenefitItem(text = feature, isDarkMode = isDarkMode)
            }
        }

        // --- 🪄 EMPUJE FLEXIBLE AL FONDO ---
        Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(16.dp))

        // --- 4. BOTÓN DE ACCIÓN ---
        Button(
            onClick = { /* TODO: Conectar Apple Pay / Google Pay / Stripe después */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (plan.isRecommended) Color.Transparent else if (isDarkMode) Color(0xFF333340) else Color(0xFFE5E7EB),
                contentColor = if (plan.isRecommended) Color.White else textColor
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (plan.isRecommended) Brush.horizontalGradient(listOf(Color(0xFFA855F7), Color(0xFFEC4899)))
                        else Brush.horizontalGradient(listOf(Color.Transparent, Color.Transparent))
                    )
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (plan.isRecommended) "Get ${plan.name}" else "Select Plan",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}