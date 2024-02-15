package com.movies.imdb.domain.repository;

import com.movies.imdb.domain.entity.Actor;

import java.util.Optional;

public interface ActorRepository {
    Optional<Actor> getById(Integer id);
}
