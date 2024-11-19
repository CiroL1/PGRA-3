package com.example.demo.model;

import java.util.*;

public class Grafo {
    private Map<MovieEntity, Set<PersonEntity>> adjMovies;
    private Map<PersonEntity, Set<MovieEntity>> adjPeople;

    public Grafo(List<MovieEntity> movies) {
        adjMovies = new HashMap<>();
        adjPeople = new HashMap<>();
        for (MovieEntity movie : movies) {
            // Agregar la película al grafo de películas
            adjMovies.putIfAbsent(movie, new HashSet<>());

            // Agregar actores y directores a la película
            for (PersonEntity actor : movie.getActors()) {
                adjMovies.get(movie).add(actor); // Conectar actor con la película
                adjPeople.putIfAbsent(actor, new HashSet<>());
                adjPeople.get(actor).add(movie); // Conectar película con el actor
            }

            for (PersonEntity director : movie.getDirectors()) {
                adjMovies.get(movie).add(director); // Conectar director con la película
                adjPeople.putIfAbsent(director, new HashSet<>());
                adjPeople.get(director).add(movie); // Conectar película con el director
            }
        }
    }

    public void agregarArista(MovieEntity movie, PersonEntity person) {
        adjMovies.get(movie).add(person);
        adjPeople.get(person).add(movie);
    }

    public String BFS(MovieEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<MovieEntity> visitadoMovies = new HashSet<>();
        Set<PersonEntity> visitadoPeople = new HashSet<>();
        Queue<Object> cola = new LinkedList<>();

        // Agregar la película inicial
        visitadoMovies.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Object actual = cola.poll();

            if (actual instanceof MovieEntity) {
                MovieEntity movie = (MovieEntity) actual;

                // Agregar la información de la película
                resultado.append("Movie: ").append(movie.getTitle()).append("\n");

                // Recorrer los actores
                for (PersonEntity actor : movie.getActors()) {
                    if (!visitadoPeople.contains(actor)) {
                        visitadoPeople.add(actor);
                        resultado.append("Actor: ").append(actor.getName())
                                .append("\n");
                        cola.add(actor); // Agregar al recorrido
                    }
                }

                // Recorrer los directores
                for (PersonEntity director : movie.getDirectors()) {
                    if (!visitadoPeople.contains(director)) {
                        visitadoPeople.add(director);
                        resultado.append("Director: ").append(director.getName())
                                .append("\n");
                        cola.add(director); // Agregar al recorrido
                    }
                }

                // Recorrer las personas conectadas
                for (PersonEntity persona : adjMovies.get(movie)) {
                    if (!visitadoPeople.contains(persona)) {
                        visitadoPeople.add(persona);
                        cola.add(persona);
                    }
                }
            } else if (actual instanceof PersonEntity) {
                PersonEntity persona = (PersonEntity) actual;

                // Recorrer las películas asociadas a esta persona
                for (MovieEntity movie : adjPeople.get(persona)) {
                    if (!visitadoMovies.contains(movie)) {
                        visitadoMovies.add(movie);
                        cola.add(movie);
                    }
                }
            }
        }

        return resultado.toString();
    }

    public String DFS(MovieEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<MovieEntity> visitadoMovies = new HashSet<>();
        Set<PersonEntity> visitadoPeople = new HashSet<>();

        // Llamada al método recursivo
        dfsRecursivo(inicio, resultado, visitadoMovies, visitadoPeople);

        return resultado.toString();
    }

    private void dfsRecursivo(Object nodo, StringBuilder resultado, Set<MovieEntity> visitadoMovies, Set<PersonEntity> visitadoPeople) {
        if (nodo instanceof MovieEntity) {
            MovieEntity movie = (MovieEntity) nodo;

            // Evitar procesar películas ya visitadas
            if (visitadoMovies.contains(movie)) return;
            visitadoMovies.add(movie);

            // Agregar información de la película
            resultado.append("Movie: ").append(movie.getTitle()).append("\n");

            // Recorrer actores
            for (PersonEntity actor : movie.getActors()) {
                if (!visitadoPeople.contains(actor)) {
                    resultado.append("Actor: ").append(actor.getName())
                            .append("\n");
                    dfsRecursivo(actor, resultado, visitadoMovies, visitadoPeople);
                }
            }

            // Recorrer directores
            for (PersonEntity director : movie.getDirectors()) {
                if (!visitadoPeople.contains(director)) {
                    resultado.append("Director: ").append(director.getName())
                            .append("\n");
                    dfsRecursivo(director, resultado, visitadoMovies, visitadoPeople);
                }
            }

            // Recorrer conexiones adicionales en el grafo
            for (PersonEntity persona : adjMovies.get(movie)) {
                if (!visitadoPeople.contains(persona)) {
                    dfsRecursivo(persona, resultado, visitadoMovies, visitadoPeople);
                }
            }
        } else if (nodo instanceof PersonEntity) {
            PersonEntity persona = (PersonEntity) nodo;

            // Evitar procesar personas ya visitadas
            if (visitadoPeople.contains(persona)) return;
            visitadoPeople.add(persona);

            // Recorrer películas asociadas a esta persona
            for (MovieEntity movie : adjPeople.get(persona)) {
                if (!visitadoMovies.contains(movie)) {
                    dfsRecursivo(movie, resultado, visitadoMovies, visitadoPeople);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Películas y personas:\n");
        for (Map.Entry<MovieEntity, Set<PersonEntity>> entry : adjMovies.entrySet()) {
            sb.append("Película: ").append(entry.getKey().getTitle()).append("\n");
            for (PersonEntity person : entry.getValue()) {
                sb.append("  Persona: ").append(person.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}