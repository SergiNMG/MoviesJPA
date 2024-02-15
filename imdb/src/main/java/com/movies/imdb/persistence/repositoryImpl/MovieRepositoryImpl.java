package com.movies.imdb.persistence.repositoryImpl;

import com.movies.imdb.domain.entity.Movie;
import com.movies.imdb.domain.repository.MovieRepository;
import com.movies.imdb.mapper.MovieMapper;
import com.movies.imdb.persistence.dao.MovieDAO;
import com.movies.imdb.persistence.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Autowired
    MovieDAO movieDAO;
    public List<Movie> getAll(){
        return MovieMapper.mapper.toMovieList(movieDAO.findAll());
    }

    public Optional<Movie> getById(Integer id){
        MovieEntity movieEntity = movieDAO.findById(id).orElse(null);
        return movieEntity != null ? Optional.of(MovieMapper.mapper.toMovieWithDirectorAndActors(movieEntity)) : Optional.empty();
    }

    public Movie save(Movie movie){
        MovieEntity movieSaved = movieDAO.save(MovieMapper.mapper.toMovieEntity(movie));
        return MovieMapper.mapper.toMovieWithDirectorAndActors(movieSaved);
    }
}
