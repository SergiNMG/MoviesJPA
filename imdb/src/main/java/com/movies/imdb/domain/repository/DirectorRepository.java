package com.movies.imdb.domain.repository;

import com.movies.imdb.domain.entity.Director;

import java.util.Optional;

public interface DirectorRepository {
    Optional<Director> getById(Integer id);
}
