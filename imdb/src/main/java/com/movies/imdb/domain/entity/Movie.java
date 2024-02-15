package com.movies.imdb.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Movie {
    private Integer id;
    private String title;
    private Integer year;
    private Integer runtime;

    private Director director;
    private List<Actor> actorList;
}
