package com.doublemc.kotflix

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotflixApplication

fun main(args: Array<String>) {
    runApplication<KotflixApplication>(*args)
}
