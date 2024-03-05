package be.kiliannuytten.poperinge_screen_designs.data.mockup

import be.kiliannuytten.poperinge_screen_designs.data.models.Spook

class Spoken {
    companion object {
        fun getSpoken(): List<Spook> {
            val spokenList = mutableListOf<Spook>()

            spokenList.addAll(
                listOf(
                    Spook(
                        "Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Broer Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Zus Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Moeder Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Vader Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Nonkel Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Tante Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Opa Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    ),
                    Spook(
                        "Oma Boo",
                        "Dit spook lijkt op Boo uit de Mario-games.",
                        "drawable/mario_boo.png"
                    )
                )
            )
            return spokenList
        }
    }
}
