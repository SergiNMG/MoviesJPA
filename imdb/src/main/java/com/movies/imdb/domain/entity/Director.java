package com.movies.imdb.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Director {
    private Integer id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
}
