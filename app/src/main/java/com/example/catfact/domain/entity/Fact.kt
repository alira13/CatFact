package com.example.catfact.domain.entity

import com.google.gson.annotations.SerializedName

class Fact {
    @SerializedName("fact")
    val fact: String? = null

    @SerializedName("length")
    val length: Int = 0
}