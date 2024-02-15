package com.movies.imdb.domain.service.impl;

import com.movies.imdb.domain.entity.Actor;
import com.movies.imdb.domain.entity.Director;
import com.movies.imdb.domain.entity.Movie;
import com.movies.imdb.domain.repository.ActorRepository;
import com.movies.imdb.domain.repository.DirectorRepository;
import com.movies.imdb.domain.repository.MovieRepository;
import com.movies.imdb.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    ActorRepository actorRepository;
    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @Override
    public Movie getById(Integer id) {
        return movieRepository.getById(id).get();
    }

    @Override
    public Movie save(Movie movie, Integer directorId, List<Integer> actorIds) {
        Director director = directorRepository.getById(directorId).orElse(null);
        List<Actor> actorList = actorIds.stream()
                .map(actorId -> actorRepository.getById(actorId)
                        .orElse(null))
                .toList();

        movie.setDirector(director);
        movie.setActorList(actorList);
        return movieRepository.save(movie);
    }
}
