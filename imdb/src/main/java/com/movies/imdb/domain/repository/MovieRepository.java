package com.movies.imdb.domain.repository;

import com.movies.imdb.domain.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> getAll();
    Optional<Movie> getById(Integer id);
    Movie save(Movie movie);
}
