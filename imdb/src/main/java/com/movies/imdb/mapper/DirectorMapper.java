package com.movies.imdb.mapper;

import com.movies.imdb.controller.model.director.DirectorListWeb;
import com.movies.imdb.domain.entity.Director;
import com.movies.imdb.persistence.model.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorMapper mapper = Mappers.getMapper(DirectorMapper.class);

    Director toDirector(DirectorEntity directorEntity);
    DirectorListWeb toDirectorListWeb(Director director);
    DirectorEntity toDirectorEntity(Director director);
}
