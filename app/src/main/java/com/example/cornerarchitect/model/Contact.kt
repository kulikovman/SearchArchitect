package com.example.cornerarchitect.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey
    val id: String,
    val surname: String,
    val name: String,
    val city: List<String>,
    val specialization: List<String>,
    val work: String?,
    val position: String?,
    val email: String,
    val phone: String,
    val instagram: String?,
    val facebook: String?,
    val vk: String?,
    val link: String?,
    val note: String?
)
