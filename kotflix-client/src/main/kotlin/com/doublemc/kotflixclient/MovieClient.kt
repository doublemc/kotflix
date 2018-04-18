package com.doublemc.kotflixclient

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class MovieClient(private val webClient: WebClient) {
    fun getMovieEvents(movieName: String) {
        webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(Movie::class.java)
                .filter { x -> x.name.equals(movieName, true) }
                .flatMap { x -> webClient.get().uri("/${x.id}/events").retrieve().bodyToFlux(MovieEvent::class.java) }
                .subscribe { println(it) }
    }
}