package com.example.amphibian.fakedata

import com.example.amphibian.network.AmphibianData

object FakeAmphibianData {
    val amphibianData = listOf(
        AmphibianData(
            name = "Great Basin Spadefoot",
            type = "Toad",
            description = "This is a toad",
            imgSrc = "greatBasin.png"
        ),
        AmphibianData(
            name = "Tiger Salamander",
            type = "Salamander",
            description = "This is a Salamander",
            imgSrc = "salamander.png"
        ),
        AmphibianData(
            name = "Pacific Chorus Frog",
            type = "Frog",
            description = "This is a Frog",
            imgSrc = "chorusFrog.png"
        )
    )
}