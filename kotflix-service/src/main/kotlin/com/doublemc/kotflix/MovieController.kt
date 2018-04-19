package com.doublemc.kotflix

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(private val service: MovieService) {

    @GetMapping("/movies")
    fun getAllMovies() = service.getAll()

    @GetMapping("/movies/{id}")
    fun getMovieById(@PathVariable id: String) = service.getById(id)

    @GetMapping("/movies/{id}/events", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun getEventsForMovie(@PathVariable id: String) = service.getEvents(id)
}