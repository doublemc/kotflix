package com.doublemc.kotflix

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Movie(
        @Id var id: String? = null,
        var name: String
)