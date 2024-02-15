package com.movies.imdb.persistence.dao;

import com.movies.imdb.persistence.model.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorDAO extends JpaRepository<DirectorEntity, Integer> {
}
