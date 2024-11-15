package com.example.demo.controller;

import com.example.demo.model.Grafo;
import com.example.demo.model.MovieEntity;
import com.example.demo.repository.MovieRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    //method implementations with walkthroughs below

    @PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/grafo")
    public Mono<String> getGrafo() {
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies -> {
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.toString(); // Devolvemos la representación en String del grafo
                });
    }

    @GetMapping("/bfs")
    public Mono<String> getBFS() {
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies -> {
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.BFS(movies.get(0)); // Devolvemos la representación en String del grafo
                });
    }

    @GetMapping("/dfs")
    public Mono<String> getDFS() {
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies -> {
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.DFS(movies.get(0)); // Devolvemos la representación en String del grafo
                });
    }

}