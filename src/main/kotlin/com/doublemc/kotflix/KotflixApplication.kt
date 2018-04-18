package com.doublemc.kotflix

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux

@SpringBootApplication
class KotflixApplication {

    @Bean
    fun initData(movieRepository: MovieRepository) = ApplicationRunner {
        val alphabet = ('A'..'Z').map(Char::toString).toTypedArray()
        val exampleMovies: Flux<Movie> = Flux.fromArray(alphabet)
                .flatMap { movieRepository.save(Movie(name = it.repeat(3))) }

        // deleting all first so we have clean db
        movieRepository.deleteAll().thenMany(exampleMovies)
                .thenMany(movieRepository.findAll())
                .subscribe({ println(it) })
    }
}


fun main(args: Array<String>) {
    runApplication<KotflixApplication>(*args)
}
