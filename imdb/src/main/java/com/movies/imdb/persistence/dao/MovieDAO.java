package com.movies.imdb.persistence.dao;

import com.movies.imdb.persistence.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<MovieEntity, Integer> {
}
