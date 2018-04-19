package com.doublemc.kotflix

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.time.Duration
import java.util.Date

@Service
class MovieService(private val repository: MovieRepository) {
    fun getAll() = repository.findAll()
    fun getById(id: String) = repository.findById(id)
    fun getEvents(id: String) = Flux.generate({ sink: SynchronousSink<MovieEvent> -> sink.next(MovieEvent(id, Date())) })
            .delayElements(Duration.ofSeconds(1))
            .doOnCancel { println("Streaming events has been canceled") }
}