package com.movies.imdb.mapper;

import com.movies.imdb.controller.model.movie.MovieDetailWeb;
import com.movies.imdb.controller.model.movie.MovieListWeb;
import com.movies.imdb.controller.model.movie.MovieSaveWeb;
import com.movies.imdb.domain.entity.Movie;
import com.movies.imdb.persistence.model.MovieEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actorList", ignore = true)
    @Named("toMovie")
    Movie toMovie(MovieEntity movieEntity);
    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actorList", ignore = true)
    @IterableMapping(qualifiedByName = "toMovie")
    List<Movie> toMovieList(List<MovieEntity> movieEntityList);
    MovieListWeb toMovieListWeb(Movie movie);
    List<MovieListWeb> toMovieListWebList(List<Movie> movieList);
    @Mapping(target = "director", expression = "java(DirectorMapper.mapper.toDirector(movieEntity.getDirectorEntity()))")
    @Mapping(target = "actorList", expression = "java(ActorMapper.mapper.toActorList(movieEntity.getActorEntityList()))")
    Movie toMovieWithDirectorAndActors(MovieEntity movieEntity);

    @Mapping(target = "directorListWeb", expression = "java(DirectorMapper.mapper.toDirectorListWeb(movie.getDirector()))")
    @Mapping(target = "actorListWebList", expression = "java(ActorMapper.mapper.toActorListWebList(movie.getActorList()))")
    MovieDetailWeb toMovieDetailWeb(Movie movie);
    @Mapping(target = "directorEntity", expression = "java(DirectorMapper.mapper.toDirectorEntity(movie.getDirector()))")
    @Mapping(target = "actorEntityList", expression = "java(ActorMapper.mapper.toActorEntityList(movie.getActorList()))")
    MovieEntity toMovieEntity(Movie movie);
    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actorList", ignore = true)
    Movie toMovie(MovieSaveWeb movieSaveWeb);

}
