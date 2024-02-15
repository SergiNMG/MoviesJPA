package com.movies.imdb.domain.service;

import com.movies.imdb.domain.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAll();
    Movie getById(Integer id);
    Movie save(Movie movie, Integer directorId, List<Integer> actorIds);
}
