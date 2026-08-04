package lopsai.jastin.dashboard.features.premium.data

object MockPlansData {
    val plans = listOf(
        PremiumPlan(
            id = "plus",
            name = "LopsAI Plus",
            price = "$8.99",
            period = "/month",
            features = listOf(
                "Access to base AI models",
                "Standard response speed",
                "50 Image generations/mo"
            )
        ),
        PremiumPlan(
            id = "pro",
            name = "LopsAI Pro",
            price = "$16.99",
            period = "/month",
            features = listOf(
                "Access to GPT-5.6 & Claude Opus-5",
                "Fastest response speed",
                "Unlimited Image generations",
                "Priority new features"
            ),
            isRecommended = true,
            badgeText = "Most Popular"
        ),
        PremiumPlan(
            id = "max",
            name = "LopsAI Max",
            price = "$149.99",
            period = "/year",
            features = listOf(
                "Everything in Pro",
                "Early access to Sora video",
                "Custom API access",
                "Dedicated support"
            ),
            badgeText = "Save 25%"
        )
    )
}