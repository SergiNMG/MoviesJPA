package com.movies.imdb.mapper;

import com.movies.imdb.controller.model.actor.ActorListWeb;
import com.movies.imdb.domain.entity.Actor;
import com.movies.imdb.persistence.model.ActorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    ActorMapper mapper = Mappers.getMapper(ActorMapper.class);

    Actor toActor(ActorEntity actorEntity);
    List<Actor> toActorList(List<ActorEntity> actorEntityList);

    ActorListWeb toActorListWeb(Actor actor);
    List<ActorListWeb> toActorListWebList(List<Actor> actorList);

    ActorEntity toActorEntity(Actor actor);
    List<ActorEntity> toActorEntityList(List<Actor> actorList);
}
