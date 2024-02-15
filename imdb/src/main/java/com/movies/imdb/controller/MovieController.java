package com.movies.imdb.controller;

import com.movies.imdb.controller.model.movie.MovieDetailWeb;
import com.movies.imdb.controller.model.movie.MovieListWeb;
import com.movies.imdb.controller.model.movie.MovieSaveWeb;
import com.movies.imdb.domain.entity.Movie;
import com.movies.imdb.domain.service.MovieService;
import com.movies.imdb.mapper.MovieMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<MovieListWeb> getAll(){
        return MovieMapper.mapper.toMovieListWebList(movieService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieDetailWeb getById(@PathVariable("id") Integer id){
        return MovieMapper.mapper.toMovieDetailWeb(movieService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public MovieDetailWeb create(@RequestBody MovieSaveWeb movieSaveWeb){
        Movie newMovie = MovieMapper.mapper.toMovie(movieSaveWeb);
        return MovieMapper.mapper.toMovieDetailWeb(movieService.save(newMovie, movieSaveWeb.getDirectorId(), movieSaveWeb.getActorIds()));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public MovieDetailWeb update(@PathVariable("id") Integer id, @RequestBody MovieSaveWeb movieSaveWeb){
        Movie existingMovie = movieService.getById(id);

        if (existingMovie != null){
            movieSaveWeb.setId(id);
            Movie updatedMovie = MovieMapper.mapper.toMovie(movieSaveWeb);
            return MovieMapper.mapper.toMovieDetailWeb(movieService.save(updatedMovie, movieSaveWeb.getDirectorId(), movieSaveWeb.getActorIds()));
        } else {
            throw new EntityNotFoundException("La película con el siguiente ID no existe: " + id);
        }
    }

}
