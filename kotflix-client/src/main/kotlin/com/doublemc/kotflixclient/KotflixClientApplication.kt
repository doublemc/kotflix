package com.doublemc.kotflixclient

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotflixClientApplication {
    @Bean
    fun subscribe(movieClient: MovieClient) = ApplicationRunner {
        movieClient.getMovieEvents("AAA")
        movieClient.getMovieEvents("BBB")
        movieClient.getMovieEvents("CCC")
    }
}

fun main(args: Array<String>) {
    runApplication<KotflixClientApplication>(*args)
}
