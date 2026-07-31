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

    // 1. 5 CHATS
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
                    text = "Here is a polished, professional version of your email:\n\n**Subject:** Q3 Performance Report Attached\n\n**Hi [Manager's Name],**\n\nI have attached the Q3 performance report for your review. Overall, we achieved strong results in sales, though marketing engagement grew at a steadier pace this quarter.\n\nLet me know if you would like to discuss the numbers in detail.\n\n**Best regards,**\n[Your Name]",
                    isUser = false
                ),
                ChatMessage(
                    text = "Thank you! Now I need to write to a major retail partner explaining that our mid-month shipment will arrive three days late due to customs delays at the port. I want to reassure them without sounding defensive. How should I phrase it?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a proactive, professional message that leads with transparency and immediately provides a solution:\n\n***\n\n**Subject:** Shipment Update: Delivery Schedule for Order #8821\n\n**Dear [Partner's Name],**\n\nWe are writing to provide a quick timeline update regarding your upcoming delivery. Due to routine customs congestion at the port of entry, shipment #8821 is now scheduled to arrive on **Friday, the 18th**, approximately three days later than our initial estimate.\n\n**What We Are Doing:**\n* We have upgraded the inland distribution leg to priority express transit at our own expense to recover as much time as possible.\n* Our logistics team is actively tracking the clearance process and will provide a confirmed delivery window by tomorrow morning.\n\nWe appreciate your understanding and are committed to ensuring a smooth receipt of your stock.\n\n**Best regards,**\n[Your Name]",
                    isUser = false
                ),
                ChatMessage(
                    text = "That was handled so smoothly. Next task: I wrote a rough draft for an invitation to our annual charity gala for top-tier donors. It sounds a bit clunky: 'We want you to come to our gala dinner next month because your donations helped a lot of people this year and there will be food and music.' Can you make it elegant and prestigious?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an elegant, prestigious invitation that honors your donors and elevates the tone of the evening:\n\n***\n\n**Subject:** An Exclusive Invitation: The Annual Foundation Gala\n\n**Dear [Guest's Name],**\n\nIt is with immense gratitude that we invite you to join us as a guest of honor at our **Annual Leadership & Impact Gala** on Friday, November 14th.\n\nThanks to your extraordinary generosity this year, our community initiatives have reached unprecedented milestones. This special evening is dedicated to celebrating that shared impact, featuring exquisite culinary pairings, live chamber music, and a private preview of our upcoming philanthropic roadmap.\n\n* **Venue:** The Grand Ballroom, Heritage Hotel\n* **Reception:** 7:00 PM | Formal Attire\n\nWe would be honored by your presence. Please let us know if we may reserve your table by responding to this email.\n\n**Warmly,**\n[Your Name]  \nExecutive Director",
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
                    text = "Here is a professional negotiation script that respects their craft while protecting your financial boundaries:\n\n***\n\n**Subject:** Proposal Review & Budget Alignment – Seminar Catering\n\n**Hi [Caterer's Name],**\n\nThank you for sending over the tasting menu and comprehensive proposal for our upcoming seminar. The culinary selections look fantastic.\n\nWe are very keen to work with your team; however, the current estimate exceeds our approved event allocation by roughly **USD 3,500**.\n\nTo bridge this difference, could we explore a few menu adjustments? For instance:\n* Transitioning from plated service to an upscale buffet-style presentation.\n* Simplification of the afternoon break offerings to coffee and pastries.\n\nCould you let us know if a revised package around our target figure is feasible? We would love to finalize the agreement this week.\n\n**Best regards,**\n[Your Name]",
                    isUser = false
                ),
                ChatMessage(
                    text = "Last request! I need to draft a brief executive update on our office sustainability initiative. We reduced paper waste by 60 percent, eliminated single-use plastics in the cafeteria, and partnered with a local recycling vendor. Format it into clean bullet points for leadership.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a crisp, executive-ready summary designed for rapid reading:\n\n***\n\n**Subject:** Q3 ESG Update – Office Sustainability & Waste Reduction Milestones\n\n**Executive Summary:**\nOur transition toward sustainable workplace operations has yielded significant measurable gains over the last quarter, reducing environmental impact while lowering recurring supplies overhead.\n\n### 🌿 Key Operational Achievements\n* **60% Reduction in Paper Consumption:** Successfully transitioned our internal billing and onboarding workflows to secure digital signing.\n* **100% Single-Use Plastic Elimination:** Replaced all disposable cutlery and cups in the employee cafeteria with commercial-grade compostable alternatives.\n* **Certified Recycling Partnership:** Executed a formal service contract with GreenCycle Corp to manage e-waste and organics, diverting 85% of office waste from landfills.\n\nWe will continue monitoring our energy efficiency metrics and share the full environmental impact report at the next board meeting.\n\n**Best regards,**\n[Your Name]  \nOperations & ESG Lead",
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
                    text = "Let's break down the quadratic function **f(x) = x² - 4x + 3** step by step:\n\n### 1. Roots (X-intercepts)\nUsing factoring, we look for two numbers that multiply to **3** and add to **-4**:\n**f(x) = (x - 1)(x - 3) = 0**\n* **Root 1:** x = 1\n* **Root 2:** x = 3\n\n### 2. Vertex\nThe x-coordinate of the vertex is at the midpoint of the roots:\n**x_v = (1 + 3) / 2 = 2**\n\nSubstitute **x = 2** back into the equation:\n**f(2) = (2)² - 4(2) + 3 = -1**\n* **Vertex:** (2, -1)\n\nThis gives you a symmetrical parabola opening upwards with its lowest point at **(2, -1)**.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That explanation is super clear! Now, how can I explain to my team why the vertex represents the absolute minimum point of this curve without getting bogged down in complex calculus?",
                    isUser = true
                ),
                ChatMessage(
                    text = "You can explain it using **visual symmetry and rates of change**—no calculus required:\n\n* **The Bowl Effect:** Because the coefficient in front of **x²** is positive (+1), the parabola opens upward like a bowl.\n* **The Turning Point:** As you move from left to right, the values drop steadily until they hit **x = 2**. At that exact instant, the downward trend stops and reverses upward.\n* **Symmetry:** Every point to the left of **x = 2** has a perfect mirror image at the same height on the right, making **(2, -1)** the indisputable floor of the function.\n\nIt is simply the balance point where decline turns into growth.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Can you show me how this quadratic curve looks when plotted on a standard Cartesian coordinate system, highlighting the axis of symmetry at x = 2?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is the plotted curve showing the exact relationship between the roots, the vertex, and the axis of symmetry:\n\n### Key Visual Markers\n* **Axis of Symmetry:** The dashed vertical line at **x = 2** divides the curve into two identical halves.\n* **X-Intercepts (1, 0) and (3, 0):** Where the function crosses the horizontal axis.\n* **Minimum Floor (2, -1):** The lowest coordinate value before the trajectory ascends.\n\nThis visual format is ideal for executive slide decks and technical presentations.",
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
                    text = "Quadratic models are the gold standard for **Revenue Optimization** because pricing always follows a parabolic curve:\n\n### The Price-Revenue Curve\n* **Pricing Too Low:** You sell thousands of units, but your margin per unit is so small that total revenue remains low.\n* **Pricing Too High:** Your margin is huge, but customer demand drops to zero, killing total revenue.\n\n### The Mathematical Optimization\nIf a company's revenue curve is modeled by **R(p) = -2p² + 120p** (where **p** is price):\n* Because the **p²** term is negative, the parabola opens downward (like an arch).\n* The vertex represents the **Maximum Achievable Revenue**.\n* Using the vertex formula **p = -b / (2a)** -> **-120 / (2 × -2) = 30**.\n\n**Business Takeaway:** Pricing your product at exactly **USD 30** captures the absolute peak of the revenue curve before price resistance erodes demand.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That business example is brilliant! To finish up, can you summarize the 3 key takeaways of quadratic models for my executive presentation and attach a profit maximization chart?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an executive summary formatted for high-level stakeholders, supported by a profit maximization curve:\n\n***\n\n**Subject:** Strategic Modeling – Utilizing Parabolic Models for Decision Making\n\n### 💡 Executive Summary\nQuadratic functions provide a mathematically rigorous framework for identifying peaks and floors across business operations, allowing teams to move from guesswork to precision forecasting.\n\n### 🎯 Three Key Takeaways\n1. **Predictable Optimization (The Vertex):** Every parabolic model contains a single mathematical turning point—identifying it reveals the exact price, staffing level, or inventory threshold that maximizes profit or minimizes cost.\n2. **Break-Even Analysis (The Roots):** The X-intercepts clearly define operating boundaries, marking the precise thresholds where a campaign or product line transitions between loss and profitability.\n3. **Symmetrical Forecasting:** Because curves are symmetrical around their axis, historical performance on the growth side can accurately predict deceleration patterns if market conditions reverse.\n\nWe will be using this modeling approach to calibrate Q4 pricing tiers across all product lines.\n\n**Best regards,**\n[Your Name]  \nFinancial & Business Analytics Lead",
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
                    text = "Here is a haiku inspired by timeless engineering and enduring craftsmanship:\n\n> *Steel across the miles,*\n> *Quiet engine hums at dawn,*\n> *Journey never fails.*",
                    isUser = false
                ),
                ChatMessage(
                    text = "That is beautiful! Now, we are designing an executive anniversary brochure celebrating legendary automotive nameplates like the Crown, Century, and Land Cruiser. Can you write a brief, lyrical prose poem that connects these names to heritage and endurance?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a lyrical brand piece tailored for an executive heritage brochure:\n\n***\n\n### The Nomenclature of Endurance\n\nSome names are merely labels; others are promises forged over generations.\n\nTo speak of the **Crown** is to recall quiet sovereignty—a graceful silhouette moving serenely through the modern metropolis. To mention the **Century** is to pause before craftsmanship that defies passing trends, where every hand-stitched detail honors tradition.\n\nAnd beyond the paved horizon stands the **Land Cruiser**—an unbroken oath between traveler and terrain. Wherever roads fade into dust and stone, the name itself becomes a compass, guaranteeing not just departure, but return.\n\nIn every letter, engineering becomes heritage; in every journey, heritage becomes legend.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That prose is stunning! Now, can you draft the copy for a minimalist print advertisement featuring a flagship luxury sedan? We want an understated, sophisticated tone with a compelling headline.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a refined, minimalist advertising layout designed for premium print publications:\n\n***\n\n### **SILENCE IS THE ULTIMATE LUXURY.**\n\nTrue distinction never raises its voice.\n\nCrafted with acoustic precision and wool-appointed serenity, the cabin is not merely a passenger space—it is a sanctuary from the world outside. Where others seek attention through spectacle, we engineer poise through restraint.\n\n**Arrive without fanfare. Be remembered without word.**\n\n*Experience the Art of Quiet Sovereignty.*",
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
                    text = "Enduring brand nomenclature relies on subtle psychological and acoustic triggers. Here are the three primary drivers:\n\n* **Acoustic Symbolism:** Words featuring hard consonants (like *C*, *K*, or *T*) convey strength, precision, and durability, while open vowels evoke smoothness and aerodynamic flow.\n* **Aspirational Framing:** Naming a vehicle after enduring concepts (*Crown*, *Century*, *Horizon*) subconsciously transfers attributes of permanence and social prestige to the owner.\n* **Narrative Anchor:** A classic name acts as a historical vessel. With each new generation of the product, the consumer is not just buying hardware, but participating in a decades-long heritage story.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! I am drafting the executive foreword for a museum exhibition catalog celebrating automotive design as an art form. Can you write a short, inspiring opening statement and attach a gallery preview visual?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an authoritative yet inspiring foreword for your exhibition catalog:\n\n***\n\n**Subject:** Foreword – The Poetry of Motion: 50 Years of Automotive Heritage\n\n### 🏛️ Foreword: Where Engineering Meets Storytelling\n\nAt its highest level, industrial design transcends pure utility to become an expression of human aspiration. An automobile is never merely steel, glass, and combustion—it is a sculpture engineered for motion.\n\nThis exhibition explores the rare intersection where uncompromising mechanical reliability meets poetic design. As you walk through these galleries, you will witness how nomenclature, proportion, and craftsmanship converge to turn everyday journeys into timeless legends.\n\nWe invite you to experience the harmony of form and endurance.\n\n**Best regards,**\n[Your Name]  \nCurator & Brand Heritage Lead",
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
                    text = "Urban green spaces are essential for resilient cities. Here are the three primary impacts:\n\n* **Heat Island Mitigation:** Parks and tree canopies lower surrounding asphalt temperatures by up to 5°C.\n* **Mental Restoration:** Access to natural foliage correlates directly with reduced cortisol levels and lower urban anxiety.\n* **Stormwater Management:** Soil and roots absorb heavy rainfall, preventing city sewage overflow.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Those points are spot on! Now I need to convince a commercial real estate developer to integrate a public green plaza into their new mixed-use development. Can you summarize the economic ROI and property value benefits of urban greenery in executive terms?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an executive summary of the commercial ROI you can present to the developer:\n\n***\n\n### The Business Case for Urban Green Plazas\n\nIntegrating accessible public greenery is no longer just an aesthetic amenity—it is a proven catalyst for commercial performance:\n\n* **Premium Property Valuation:** Commercial office spaces overlooking well-maintained greenery command up to **15% higher lease rates** and experience shorter vacancy cycles.\n* **Increased Foot Traffic & Dwell Time:** Retail and dining tenants surrounding green plazas benefit from a **25% increase in dwell time**, translating directly to higher average ticket sales.\n* **Reduced Infrastructure Operating Costs:** Green roofs and shaded plazas reduce building HVAC cooling demands during summer months by up to **20%** while serving as natural stormwater retention systems.\n\nInvesting in a public plaza directly elevates the net operating income (NOI) of the surrounding development.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That financial angle is compelling. Next, we are drafting a proposal for the City Council to transform an underutilized surface parking lot into a 'pocket park'. Can you draft a persuasive executive pitch and attach a concept rendering?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a persuasive executive pitch tailored for municipal leadership:\n\n***\n\n### **Project Proposal: The Midtown Pocket Park Initiative**\n\n**Executive Summary:**\nWe propose converting the underutilized municipal surface lot on 4th Street into a high-impact urban pocket park. This strategic transformation converts a low-yield concrete asset into a thriving neighborhood hub that enhances public health and urban resilience.\n\n**Core Community Benefits:**\n* **Urban Cooling & Biodiversity:** Replaces 12,000 sq. ft. of heat-absorbing asphalt with native shade trees and drought-tolerant perennials.\n* **Economic Micro-Activation:** Creates an attractive lunchtime gathering space for surrounding office workers, driving daytime patronage to local food vendors.\n* **Low-Cost Deployment:** Utilizes modular seating and permeable gravel pathways to minimize initial capital expenditure while maximizing community impact.\n\n*Let's transform static infrastructure into living community value.*",
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
                    text = "Here is a structured, reassuring response designed to neutralize budget and water consumption concerns during the Q&A:\n\n***\n\n### Re: Mitigating Ongoing Water and Maintenance Costs\n\n**1. Xeriscaping & Native Species Selection:**\nBy strictly planting native, drought-resistant perennials and ornamental grasses, the park will require **zero supplemental irrigation** once root systems are established during the first growing season.\n\n**2. Smart Drainage & Passive Retention:**\nThe design incorporates bioswales that naturally capture and store rainwater run-off from adjacent rooftops, eliminating the need for municipal tap water use.\n\n**3. Minimal Staffing Overhead:**\nUnlike traditional turf grass which requires weekly mowing and fertilization, a native plant landscape requires only bi-annual seasonal pruning, reducing long-term labor costs by **65% compared to conventional parks**.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! I need to send a formal update email to the Mayor's Sustainability Task Force summarizing our green canopy milestones for Q3. Format it for rapid scannability and attach our urban forestry progress infographic.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a formal, highly scannable executive update ready for the Task Force:\n\n***\n\n**Subject:** Q3 Urban Forestry & Green Space Progress Report\n\n**Dear Members of the Sustainability Task Force,**\n\nWe are pleased to present our quarterly progress summary regarding municipal canopy expansion and green space revitalization.\n\n### 🌳 Key Q3 Milestones\n* **Tree Canopy Density:** Completed the installation of **450 urban shade trees** across high-heat commercial corridors, putting us 10% ahead of our annual sustainability target.\n* **Permeable Surface Conversion:** Transformed **35,000 square feet** of degraded municipal concrete into permeable, planted streetscapes to assist with storm drainage.\n* **Community Engagement:** Onboarded **12 corporate sponsorship partners** to fund ongoing maintenance of downtown pocket parks, ensuring fiscal sustainability.\n\nWe look forward to presenting the full environmental impact dashboard at next month's board session.\n\n**Best regards,**\n[Your Name]  \nDirector of Urban Resilience & Sustainability",
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
                    text = "For a realistic neon glow, follow this 3-layer technique:\n\n1. **Base Layer (Normal):** Paint the solid core of the light in crisp white or very light pastel.\n2. **Glow Layer 1 (Add / Linear Dodge):** Use a soft airbrush with your saturated neon color (e.g., cyan or magenta) around the white core.\n3. **Ambient Layer (Screen):** Lower the opacity to 30% and paint a wide, soft halo around the surrounding environment to simulate light bounce.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That 3-layer technique made the glow pop instantly! Now we are refining the color palette for the key visual. Why do complementary color schemes like cyan and warm orange work so well in modern commercial illustration?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Complementary palettes like cyan and warm orange dominate commercial illustration because they maximize **chromatic contrast and emotional clarity**:\n\n* **Visual Hierarchy:** Cool teals and cyans naturally recede into the background, while warm oranges and ambers advance toward the viewer, instantly telling the eye where to focus.\n* **Thermal Balance:** Combining warm and cool light sources mimics natural atmospheric phenomena (like sunset against deep shadow), which humans find inherently pleasing and cinematic.\n* **Brand Impact:** High-contrast palettes perform exceptionally well on small mobile displays, preventing image muddying in social media feeds.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That color theory explanation is brilliant. Can you draft an executive creative pitch to our agency's Creative Director proposing a stylized digital illustration approach for a global sneaker campaign? Keep it punchy and authoritative.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is a compelling creative pitch designed for executive leadership:\n\n***\n\n**Subject:** Creative Pitch: Stylized Digital Illustration for Q4 Campaign\n\n**Hi [Creative Director's Name],**\n\nTo break through the visual clutter of traditional studio photography, we propose a high-impact **Stylized Digital Illustration** approach for our upcoming sneaker launch.\n\nBy replacing stock renders with custom illustrated lighting and dynamic color grading, we can position the product as a cultural artifact rather than just a physical commodity.\n\n### Strategic Advantages\n* **Unrestricted Visual Worlds:** Freely manipulate gravity, lighting, and environment without the budget constraints of physical set builds.\n* **Cross-Platform Adaptability:** Vector-backed raster assets scale seamlessly from mobile story formats to large-scale retail window displays.\n* **Elevated Brand Prestige:** Distinctive artistic direction reinforces our client's reputation as a design-forward industry leader.\n\nI would love to walk you through our initial style frames during tomorrow's sync.\n\n**Best regards,**\n[Your Name]  \nLead Art Director",
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
                    text = "Professional design studios ensure non-destructive workflows by enforcing a **Strict Modular Layering Hierarchy**:\n\n* **Separate Line, Flat, and Shadow Groups:** Never merge line art with color fills. Keep primary local colors on discrete layers so brand palette swaps take seconds instead of hours.\n* **Use Clipping Masks for Texture:** Apply brushes, grit, and ambient occlusion exclusively via clipping masks over flat shapes, ensuring the base silhouettes remain sharp and editable.\n* **Global Adjustment Layers:** Manage overall contrast and color temperature using top-level adjustment curves rather than painting lighting directly onto object layers.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Final request for this thread! Please draft a concise executive summary for our creative operations report highlighting how adopting standardized digital art workflows improved our studio efficiency, and attach a studio showcase visual.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is an executive summary formatted for your monthly creative operations report:\n\n***\n\n**Subject:** Studio Operations Report – Workflow Standardization & Efficiency Gains\n\n### 🎨 Executive Summary\nThe implementation of standardized digital illustration pipelines and modular layer architectures has significantly streamlined production velocity across our commercial design teams.\n\n### 📈 Core Operational Takeaways\n1. **35% Faster Revision Turnaround:** By enforcing non-destructive clipping masks and modular color grouping, client-requested palette modifications are now executed in minutes.\n2. **Consistent Visual Quality:** Standardizing our custom brush libraries and lighting templates across all senior artists eliminated style drift across multi-asset campaigns.\n3. **Reduced File Footprint:** Implementing structured export protocols reduced our shared server storage consumption while accelerating cross-department asset delivery to the motion graphics team.\n\nWe recommend rolling out this standardized digital workflow across all global creative pods next quarter.\n\n**Best regards,**\n[Your Name]  \nDirector of Creative Operations",
                    isUser = false,
                    imageRes = Res.drawable.art_4_studio
                )
            )

            // FALLBACK DE SEGURIDAD PARA EVITAR CRASH
            else -> listOf(
                ChatMessage(
                    text = "Can we review our notes on this topic? I'm attaching a photo of our current sprint board to show where we are; we've got a lot of tickets stuck in the review stage.",
                    isUser = true,
                    imageRes = Res.drawable.typo_1_report
                ),
                ChatMessage(
                    text = "Of course! Here is the summarized thread and key takeaways regarding this topic up to this point. Based on the notes and your image, the primary focus needs to be on unblocking that review stage.\n\n### Key Open Items\n* **Resource Allocation:** Team alpha is waiting on client approval for deliverables.\n* **Technical Spikes:** Two major architecture decisions are pending C-suite review.\n\nLet me know how you would like to proceed with this topic.",
                    isUser = false
                ),
                ChatMessage(
                    text = "Let's focus on unblocking the client approval deliverables. Can you help me draft a polite, tactful email to the stakeholders requesting an expedited review so team alpha can resume velocity?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Certainly, here is a professional draft designed to encourage prompt review without being aggressive:\n\n***\n\n**Subject:** Deliverables Submitted - Request for Expedited Review\n\n**Dear [Stakeholder Name],**\n\nI hope this email finds you well.\n\nRegarding our current project phase, our team alpha submitted the major deliverables for your review early this week. As we approach our next critical sprint milestone, a finalized review of these items will ensure we maintain our planned production velocity and hit our targeted delivery dates.\n\nCould your team provide feedback by **Thursday at 3:00 PM**? This will give us the necessary time to address any inputs before the weekend code freeze.\n\nThank you for your partnership. Please let me know if you need to schedule a brief sync to walk through these items.\n\n**Best regards,**\n[Your Name]",
                    isUser = false
                ),
                ChatMessage(
                    text = "That email draft is great. Now, regarding those technical spikes—I need a concise decision matrix summarizing the architectural choices for the upcoming leadership meeting. Can you compile a quick one?",
                    isUser = true
                ),
                ChatMessage(
                    text = "Absolutely. Here is a streamlined executive decision matrix summarizing the pending architectural choices based on our previous discussions. This format is ideal for gaining high-level consensus:\n\n| Option | Description | Trade-offs | Scalability Impact |\n| :--- | :--- | :--- | :--- |\n| **A** | Serverless Architecture | Lower immediate cost, higher operational complexity | Highest |\n| **B** | Dedicated Cloud Infrastructure | Predictable costs, longer set-up time | Moderate |\n| **C** | Hybrid Solution | Existing compatibility, higher long-term management | Limited |\n\nI recommend prioritizing **Option B** for long-term stability unless cost is the absolute defining constraint.",
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
                    text = "Here are the talking points structured for the budget variance update, designed to position the slight overspend as a strategic investment in speed:\n\n***\n\n### Budget Variance & Roadmap Acceleration Update\n\n**1. The Current State:**\n* Currently forecasting roughly **10 percent over budget** for Phase 1. This variance is primarily driven by additional front-end resources allocated to key deliverables.\n\n**2. The Strategic Return on Investment (ROI):**\n* **Roadmap Acceleration:** By front-loading these resources, we accelerated the Phase 1 roadmap by **two full sprints** (4 weeks). We effectively traded near-term budget for significant long-term time savings.\n* **Client Confidence:** Accelerating these deliverables improved the client's internal validation timelines, reducing long-term project friction.\n\n**3. Mitigation & The Path Forward:**\n* We will utilize the generated efficiencies in Phase 2 to normalize the budget variance and revert to the baseline spend profile.",
                    isUser = false
                ),
                ChatMessage(
                    text = "That is a strong narrative. Last request for this thread: please draft a concise executive summary of this entire note review session focusing on the unblocking actions and communication strategy.",
                    isUser = true
                ),
                ChatMessage(
                    text = "Here is the definitive executive summary of our note review session regarding this topic:\n\n***\n\n**Subject:** Executive Summary – Note Review & Action Plan\n\n**Current Status & Key Unblocking Actions:**\n* The team identified primary project roadblocks in deliverable review and pending architectural decisions.\n\n### Strategic Action Plan\n1. **Client Communication:** A tactful email was drafted to client leadership requesting expedited review of team alpha's deliverables, emphasizing the planned production velocity.\n2. **Architecture Decision Matrix:** A matrix was generated to facilitate high-level consensus on pending architecture spikes during the upcoming leadership meeting.\n3. **Budget Variance Management:** Talking points were prepared to frame the projected 10 percent overspend as a strategic investment in accelerating the roadmap by two sprints.\n\nWe will resume note-taking after the upcoming leadership sync.\n\n**Best regards,**\n[Your Name]  \nProject Management & Strategic Partner",
                    isUser = false,
                    imageRes = Res.drawable.art_4_studio
                )
            )
        }
    }
}