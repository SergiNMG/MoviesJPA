package com.movies.imdb.controller.model.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieListWeb {
    private Integer id;
    private String title;
    private String runtime;
}
