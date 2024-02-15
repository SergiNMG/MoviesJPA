package com.movies.imdb.controller.model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movies.imdb.controller.model.actor.ActorListWeb;
import com.movies.imdb.controller.model.director.DirectorListWeb;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieDetailWeb {
    private Integer id;
    private String title;
    private Integer year;
    private Integer runtime;

    @JsonProperty("director")
    private DirectorListWeb directorListWeb;
    @JsonProperty("actors")
    private List<ActorListWeb> actorListWebList;
}
