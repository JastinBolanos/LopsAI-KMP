package lopsai.jastin.dashboard.features.chat.data

import lopsai.jastin.dashboard.core.models.ChatMessage
import lopsai_kmp.shared.generated.resources.Res
import lopsai_kmp.shared.generated.resources.art_1_sketch
import lopsai_kmp.shared.generated.resources.art_2_sneaker
import lopsai_kmp.shared.generated.resources.art_3_visual
import lopsai_kmp.shared.generated.resources.art_4_studio
import lopsai_kmp.shared.generated.resources.quad_1_worksheet
import lopsai_kmp.shared.generated.resources.quad_2_chart
import lopsai_kmp.shared.generated.resources.quad_3_cheatsheet
import lopsai_kmp.shared.generated.resources.quad_4_revenue
import lopsai_kmp.shared.generated.resources.toyota_1_moodboard
import lopsai_kmp.shared.generated.resources.toyota_2_sedan
import lopsai_kmp.shared.generated.resources.toyota_3_landscape
import lopsai_kmp.shared.generated.resources.toyota_4_museum
import lopsai_kmp.shared.generated.resources.typo_1_report
import lopsai_kmp.shared.generated.resources.typo_2_gala
import lopsai_kmp.shared.generated.resources.typo_3_csat
import lopsai_kmp.shared.generated.resources.typo_4_esg
import lopsai_kmp.shared.generated.resources.urban_1_aerial
import lopsai_kmp.shared.generated.resources.urban_2_park
import lopsai_kmp.shared.generated.resources.urban_3_rooftop
import lopsai_kmp.shared.generated.resources.urban_4_infographic

object MockChatsData {

    val chatTitles = listOf(
        "Typo Assistance Request",
        "Quadratic Function Plot",
        "Toyota Names Poetry",
        "Urban Green Spaces",
        "Digital Art Techniques"
    )

    fun getConversation(title: String): List<ChatMessage> {
        return when (title) {
            "Typo Assistance Request" -> listOf(
                ChatMessage(
                    text = "Can you check this email for professional tone and fix any typos?\n'Hey boss, im attaching the report for Q3, we did great on sales but marketing was kinda slow.'",
                    isUser = true,
                    imageRes = Res.drawable.typo_1_report
                ),
                ChatMessage(
                    text = "Here is a polished version:\n\nSubject: Q3 Performance Report Attached\n\nHi [Manager's Name],\n\nI have attached the Q3 performance report. We achieved strong sales results, though marketing engagement grew steadily.\n\nLet me know if you want to discuss the details.\n\nBest regards,\nGabriel",
                    isUser = false
                ),
                ChatMessage(
                    text = "Thank you! Now I need to write to a major retail partner explaining that our mid-month shipment will arrive three days late due to customs delays at the port. I want to reassure them without sounding defensive. How should I phrase it?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a proactive message:\n\nSubject: Delivery Schedule Update: Order 8821\n\nDear [Partner's Name],\n\nDue to port customs congestion, shipment 8821 is now scheduled to arrive on Friday, the 18th (three days later).\n\nOur Actions:\n- Upgraded to priority express transit at our expense.\n- Tracking clearance closely to confirm the delivery window by tomorrow.\n\nThank you for your understanding.\n\nBest regards,\nGabriel",
                    isUser = false
                ),
                ChatMessage(
                    text = "That was handled so smoothly. Next task: I wrote a rough draft for an invitation to our annual charity gala for top-tier donors. It sounds a bit clunky: 'We want you to come to our gala dinner next month because your donations helped a lot of people this year and there will be food and music.' Can you make it elegant and prestigious?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an elegant invitation:\n\nSubject: An Exclusive Invitation: The Annual Foundation Gala\n\nDear [Guest's Name],\n\nWe invite you as a guest of honor to our Annual Leadership & Impact Gala on Friday, Nov 14th.\n\nThanks to your extraordinary generosity, we've reached unprecedented milestones. Join us for exquisite culinary pairings and live chamber music to celebrate.\n\n- Venue: The Grand Ballroom, Heritage Hotel\n- Reception: 7:00 PM | Formal Attire\n\nPlease let us know if we may reserve your table.\n\nWarmly,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.typo_2_gala
                ),
                ChatMessage(
                    text = "Perfect! Our customer service team just hit a historic 96 percent CSAT score this month. Can you generate a clean, celebratory graphic card with no text that I can post in our team group to surprise them?",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.typo_3_csat
                ),
                ChatMessage(
                    text = "That graphic is stunning! Another situation: A catering supplier sent us a quote for an upcoming corporate seminar that is USD 3,500 over our approved budget. How can I politely negotiate the price down while asking if we can adjust the menu selections to fit our target?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a professional negotiation script:\n\nSubject: Proposal Review – Seminar Catering\n\nHi [Caterer's Name],\n\nThank you for the fantastic proposal. However, it exceeds our budget by USD 3,500.\n\nCould we explore adjustments to bridge this gap? For example:\n- Transitioning to a buffet-style presentation.\n- Simplifying the afternoon break to coffee and pastries.\n\nPlease let us know if a revised package is feasible.\n\nBest regards,\nGabriel",
                    isUser = false
                ),
                ChatMessage(
                    text = "Last request! I need to draft a brief executive update on our office sustainability initiative. We reduced paper waste by 60 percent, eliminated single-use plastics in the cafeteria, and partnered with a local recycling vendor. Format it into clean bullet points for leadership.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a crisp executive summary:\n\nSubject: Q3 ESG Update – Sustainability Milestones\n\nExecutive Summary:\nOur sustainable operations transition has yielded great results:\n\n- 60% Less Paper: Transitioned to secure digital signing.\n- 0% Single-Use Plastics: Switched to compostable cafeteria alternatives.\n- Recycling Partnership: Partnered with GreenCycle Corp to divert 85% of office waste from landfills.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.typo_4_esg
                )
            )

            "Quadratic Function Plot" -> listOf(
                ChatMessage(
                    text = "How do I find the vertex and roots of the quadratic function f(x) = x² - 4x + 3? I'm attaching a photo of my practice worksheet so you can see the curve I'm trying to graph.",
                    isUser = true,
                    imageRes = Res.drawable.quad_1_worksheet
                ),
                ChatMessage(
                    text = "Let's break down f(x) = x² - 4x + 3:\n\n1. Roots\nFactoring gives (x - 1)(x - 3) = 0, so roots are at x = 1 and x = 3.\n\n2. Vertex\nThe x-coordinate is the midpoint: (1 + 3) / 2 = 2.\nSubstitute x = 2: f(2) = (2)² - 4(2) + 3 = -1.\n\nThe vertex (lowest point) is (2, -1).",
                    isUser = false
                ),
                ChatMessage(
                    text = "That explanation is super clear! Now, how can I explain to my team why the vertex represents the absolute minimum point of this curve without getting bogged down in complex calculus?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Explain it using visual symmetry:\n\n- The Bowl: The positive x² makes it open upward.\n- The Turning Point: Values drop until x = 2, then reverse upward.\n- Symmetry: Every point has a mirror image, making (2, -1) the absolute floor.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Can you show me how this quadratic curve looks when plotted on a standard Cartesian coordinate system, highlighting the axis of symmetry at x = 2?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is the plotted curve:\n\n- Axis of Symmetry: The vertical line at x = 2.\n- X-Intercepts: (1, 0) and (3, 0).\n- Minimum Floor: (2, -1).",
                    isUser = false,
                    imageRes = Res.drawable.quad_2_chart
                ),
                ChatMessage(
                    text = "Perfect! Can you generate a clean visual cheat sheet card of quadratic formula rules without any accompanying text? I want to insert the image directly into my presentation slide.",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.quad_3_cheatsheet
                ),
                ChatMessage(
                    text = "Awesome. How do we apply quadratic functions in real-world business economics? Can you give me a clear example of how a company uses a parabola to optimize pricing and maximize profit?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Quadratic models optimize Revenue:\n\nIf revenue is R(p) = -2p² + 120p (where p is price):\n- The downward parabola shows revenue peaking, then dropping if priced too high.\n- Using the vertex formula (p = -b / 2a): -120 / -4 = 30.\n\nPricing at USD 30 maximizes revenue before demand drops.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That business example is brilliant! To finish up, can you summarize the 3 key takeaways of quadratic models for my executive presentation and attach a profit maximization chart?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is the summary:\n\nSubject: Strategic Parabolic Modeling\n\n🎯 Key Takeaways\n1. Predictable Optimization: The vertex reveals the exact price to maximize profit.\n2. Break-Even Analysis: The roots mark thresholds between loss and profitability.\n3. Symmetrical Forecasting: Historical growth accurately predicts deceleration patterns.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.quad_4_revenue
                )
            )

            "Toyota Names Poetry" -> listOf(
                ChatMessage(
                    text = "Write a short haiku about Toyota cars and reliability. I'm attaching an inspiring moodboard image of classical automotive engineering to set the tone.",
                    isUser = true,
                    imageRes = Res.drawable.toyota_1_moodboard
                ),
                ChatMessage(
                    text = "Here is a haiku inspired by timeless engineering:\n\n> Steel across the miles,\n> Quiet engine hums at dawn,\n> Journey never fails.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That is beautiful! Now, we are designing an executive anniversary brochure celebrating legendary automotive nameplates like the Crown, Century, and Land Cruiser. Can you write a brief, lyrical prose poem that connects these names to heritage and endurance?",
                    isUser = true
                ),
                ChatMessage(
                    text = "The Nomenclature of Endurance\n\nTo speak of the Crown is to recall quiet sovereignty. The Century pauses before craftsmanship that defies trends.\n\nBeyond the paved horizon stands the Land Cruiser—an unbroken oath between traveler and terrain. In every letter, engineering becomes heritage.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That prose is stunning! Now, can you draft the copy for a minimalist print advertisement featuring a flagship luxury sedan? We want an understated, sophisticated tone with a compelling headline.",
                    isUser = true
                ),
                ChatMessage(
                    text = "SILENCE IS THE ULTIMATE LUXURY.\n\nTrue distinction never raises its voice. Crafted with acoustic precision, the cabin is a sanctuary. We engineer poise through restraint.\n\nArrive without fanfare. Be remembered without word.",
                    isUser = false,
                    imageRes = Res.drawable.toyota_2_sedan
                ),
                ChatMessage(
                    text = "We love that creative direction! Can you generate a clean, text-free atmospheric landscape image that captures this mood of 'quiet journey and forward momentum' so we can use it as our presentation background slide?",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.toyota_3_landscape
                ),
                ChatMessage(
                    text = "That image is perfect for our backdrop! Let's pivot slightly to brand strategy: How do classic automotive names create such strong emotional resonance with customers? Give me 3 bullet points explaining the phonetics and psychology behind enduring product names.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Enduring names rely on subtle triggers:\n\n- Acoustic Symbolism: Hard consonants convey strength; open vowels evoke smoothness.\n- Aspirational Framing: Names like Crown transfer attributes of prestige.\n- Narrative Anchor: A classic name acts as a historical vessel spanning generations.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! I am drafting the executive foreword for a museum exhibition catalog celebrating automotive design as an art form. Can you write a short, inspiring opening statement and attach a gallery preview visual?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Foreword – The Poetry of Motion\n\n🏛️ Where Engineering Meets Storytelling\n\nAn automobile is a sculpture engineered for motion. This exhibition explores the rare intersection where mechanical reliability meets poetic design, turning everyday journeys into timeless legends.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.toyota_4_museum
                )
            )

            "Urban Green Spaces" -> listOf(
                ChatMessage(
                    text = "Why are urban green spaces so critical for modern cities? Give me 3 bullet points. I'm attaching an aerial photograph of a downtown district we are currently analyzing for our urban revitalization project.",
                    isUser = true,
                    imageRes = Res.drawable.urban_1_aerial
                ),
                ChatMessage(
                    text = "Urban green spaces impact cities by:\n\n- Cooling: Parks lower asphalt temperatures by up to 5°C.\n- Mental Health: Foliage access reduces cortisol and urban anxiety.\n- Stormwater: Soil absorbs heavy rainfall, preventing floods.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Those points are spot on! Now I need to convince a commercial real estate developer to integrate a public green plaza into their new mixed-use development. Can you summarize the economic ROI and property value benefits of urban greenery in executive terms?",
                    isUser = true
                ),
                ChatMessage(
                    text = "The Business Case for Green Plazas\n\n- Premium Valuation: Greenery-facing offices command up to 15% higher lease rates.\n- Increased Traffic: Surrounding retail sees a 25% increase in dwell time and sales.\n- Reduced Costs: Green roofs lower building HVAC cooling demands by up to 20%.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That financial angle is compelling. Next, we are drafting a proposal for the City Council to transform an underutilized surface parking lot into a 'pocket park'. Can you draft a persuasive executive pitch and attach a concept rendering?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Project: The Midtown Pocket Park\n\nExecutive Summary:\nTransforming the 4th Street surface lot into a pocket park boosts urban resilience.\n\nBenefits:\n- Urban Cooling: Replaces 12,000 sq. ft. of asphalt with shade trees.\n- Economic Activation: Drives daytime patronage to local vendors.\n- Low-Cost: Utilizes modular seating to minimize capital expenditure.",
                    isUser = false,
                    imageRes = Res.drawable.urban_2_park
                ),
                ChatMessage(
                    text = "We love that concept rendering! Can you generate a clean, text-free architectural visualization of a sustainable rooftop garden that we can use as the background slide for our final stakeholder presentation?",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.urban_3_rooftop
                ),
                ChatMessage(
                    text = "That backdrop slide looks gorgeous. One of the council members raised a concern about ongoing municipal maintenance costs and water usage. How can we address this in our Q&A session using smart xeriscaping principles?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Mitigating Water & Maintenance Costs\n\n- Xeriscaping: Native, drought-resistant plants require zero supplemental irrigation.\n- Passive Drainage: Bioswales capture rainwater, eliminating tap water use.\n- Low Labor: Requires only bi-annual pruning, cutting labor costs by 65%.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! I need to send a formal update email to the Mayor's Sustainability Task Force summarizing our green canopy milestones for Q3. Format it for rapid scannability and attach our urban forestry progress infographic.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Q3 Urban Forestry Progress Report\n\n🌳 Key Milestones\n- Canopy Density: Installed 450 shade trees across commercial corridors.\n- Permeable Surfaces: Transformed 35,000 sq. ft. of concrete to assist drainage.\n- Sponsorships: Onboarded 12 corporate partners to fund ongoing maintenance.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.urban_4_infographic
                )
            )

            "Digital Art Techniques" -> listOf(
                ChatMessage(
                    text = "What blending mode should I use in Procreate for glowing neon lights? I'm attaching a cyberpunk concept sketch we are developing for a commercial client.",
                    isUser = true,
                    imageRes = Res.drawable.art_1_sketch
                ),
                ChatMessage(
                    text = "Use this 3-layer neon technique:\n\n1. Base (Normal): Solid core in white.\n2. Glow (Add): Soft airbrush with saturated color around the core.\n3. Ambient (Screen): Lower opacity (30%) wide halo to simulate light bounce.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That 3-layer technique made the glow pop instantly! Now we are refining the color palette for the key visual. Why do complementary color schemes like cyan and warm orange work so well in modern commercial illustration?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Complementary palettes (cyan/orange) work because:\n\n- Visual Hierarchy: Cool cyans recede, warm oranges advance, guiding the eye.\n- Thermal Balance: Mimics pleasing natural phenomena like sunsets.\n- Brand Impact: High-contrast prevents image muddying on mobile.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That color theory explanation is brilliant. Can you draft an executive creative pitch to our agency's Creative Director proposing a stylized digital illustration approach for a global sneaker campaign? Keep it punchy and authoritative.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Creative Pitch: Stylized Digital Illustration\n\nHi [Director],\n\nWe propose Stylized Digital Illustration for the sneaker launch to break through traditional visual clutter.\n\nAdvantages\n- Unrestricted Worlds: Manipulate lighting without set-build costs.\n- Adaptability: Scales seamlessly from mobile to retail displays.\n- Prestige: Reinforces our client's reputation as a design leader.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.art_2_sneaker
                ),
                ChatMessage(
                    text = "We love the tone of that pitch! Can you generate a clean, text-free visual showing a stylized sneaker illustration with vibrant lighting contrasts so I can embed it directly into our client presentation?",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.art_3_visual
                ),
                ChatMessage(
                    text = "That visual asset looks incredible! One operational question from our studio leads: How should our illustration team structure their layer hierarchies to ensure fast client revisions without having to repaint entire scenes?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Ensure fast revisions with Modular Layering:\n\n- Separate Line/Color: Keep local colors discrete for instant palette swaps.\n- Clipping Masks: Apply textures via masks to keep base silhouettes editable.\n- Global Adjustments: Manage contrast with top-level curves, not by painting directly.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! Please draft a concise executive summary for our creative operations report highlighting how adopting standardized digital art workflows improved our studio efficiency, and attach a studio showcase visual.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Studio Operations Report\n\n🎨 Executive Summary\nStandardized workflows streamlined our production velocity.\n\n📈 Core Takeaways\n1. 35% Faster Revisions: Modular grouping enables palette swaps in minutes.\n2. Consistent Quality: Shared brush libraries eliminated style drift.\n3. Reduced File Size: Export protocols accelerated cross-department delivery.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.art_4_studio
                )
            )

            // FALLBACK DE SEGURIDAD
            else -> listOf(
                ChatMessage(
                    text = "Can we review our notes on this topic? I'm attaching a photo of our current sprint board to show where we are; we've got a lot of tickets stuck in the review stage.",
                    isUser = true,
                    imageRes = Res.drawable.typo_1_report
                ),
                ChatMessage(
                    text = "Here are the key takeaways to unblock the review stage:\n\n- Resource Allocation: Team alpha awaits client approval.\n- Technical Spikes: Two architecture decisions await C-suite review.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Let's focus on unblocking the client approval deliverables. Can you help me draft a polite, tactful email to the stakeholders requesting an expedited review so team alpha can resume velocity?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Request for Expedited Review\n\nDear [Stakeholder],\n\nTeam alpha submitted deliverables early this week. To maintain velocity and hit delivery dates, could you provide feedback by Thursday at 3:00 PM?\n\nThank you for your partnership.\n\nBest regards,\nGabriel",
                    isUser = false
                ),
                ChatMessage(
                    text = "That email draft is great. Now, regarding those technical spikes—I need a concise decision matrix summarizing the architectural choices for the upcoming leadership meeting. Can you compile a quick one?",
                    isUser = true
                ),
                ChatMessage(
                    text = "| Option | Description | Scalability |\n| :--- | :--- | :--- |\n| A | Serverless | Highest |\n| B | Dedicated Cloud | Moderate |\n| C | Hybrid Solution | Limited |\n\nI recommend Option B for long-term stability.",
                    isUser = false,
                    imageRes = Res.drawable.quad_2_chart
                ),
                ChatMessage(
                    text = "That matrix helps a lot. Last thing, we are forecasting slightly over budget for the current phase, perhaps by 10 percent. Can you generate an image that visualizes financial acceleration against budget targets for our final slide?",
                    isUser = true
                ),
                ChatMessage(
                    text = "",
                    isUser = false,
                    imageRes = Res.drawable.toyota_3_landscape
                ),
                ChatMessage(
                    text = "Thank you for the visual asset. Based on that image, can you help me structure the talking points for that budget variance update, highlighting the roadmap acceleration we achieved?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Budget Variance Update\n\n- Current State: Forecasting 10% over budget due to front-loaded resources.\n- Strategic ROI: This accelerated the roadmap by 4 weeks.\n- Path Forward: We will use these efficiencies to normalize Phase 2 spending.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That is a strong narrative. Last request for this thread: please draft a concise executive summary of this entire note review session focusing on the unblocking actions and communication strategy.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Subject: Executive Summary – Action Plan\n\nStrategic Action Plan\n1. Client Communication: Requested expedited review to maintain velocity.\n2. Architecture: Matrix generated for C-suite consensus.\n3. Budget: Framed the 10% overspend as a strategic roadmap acceleration.\n\nBest regards,\nGabriel",
                    isUser = false,
                    imageRes = Res.drawable.art_4_studio
                )
            )
        }
    }
}