package com.movies.imdb.persistence.dao;

import com.movies.imdb.persistence.model.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDAO extends JpaRepository<ActorEntity, Integer> {
}
