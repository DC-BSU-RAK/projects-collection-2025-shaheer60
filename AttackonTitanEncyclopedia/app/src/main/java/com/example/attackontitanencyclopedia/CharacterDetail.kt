package com.example.attackontitanencyclopedia

import androidx.annotation.DrawableRes

data class CharacterDetail(
    val name: String,
    @DrawableRes val imageResId: Int,
    val affiliation: String,
    val titanForm: String,
    val height: String,
    val status: String,
    val birthday: String,
    val bloodType: String,
    val voiceActor: String,
    val firstAppearance: String,
    val bio: String
)
