package com.movies.imdb.controller.model.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieSaveWeb {
    private Integer id;
    private String title;
    private Integer year;
    private Integer runtime;

    private Integer directorId;
    private List<Integer> actorIds;
}
