package lopsai.jastin.dashboard.features.premium.data

data class PremiumPlan(
    val id: String,
    val name: String,
    val price: String,
    val period: String,
    val features: List<String>,
    val isRecommended: Boolean = false,
    val badgeText: String? = null
)