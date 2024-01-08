package com.example.homework2android2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nature(
    val natureImage: Int,
    val descriptionOfNature: String
): Parcelable
