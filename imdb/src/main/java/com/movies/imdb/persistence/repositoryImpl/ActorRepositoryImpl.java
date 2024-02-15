package com.movies.imdb.persistence.repositoryImpl;

import com.movies.imdb.domain.entity.Actor;
import com.movies.imdb.domain.repository.ActorRepository;
import com.movies.imdb.mapper.ActorMapper;
import com.movies.imdb.persistence.dao.ActorDAO;
import com.movies.imdb.persistence.model.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ActorRepositoryImpl implements ActorRepository {
    @Autowired
    ActorDAO actorDAO;

    public Optional<Actor> getById(Integer id){
        ActorEntity actorEntity = actorDAO.findById(id).orElse(null);
        return actorEntity != null ? Optional.ofNullable(ActorMapper.mapper.toActor(actorEntity)) : Optional.empty();
    }
}
