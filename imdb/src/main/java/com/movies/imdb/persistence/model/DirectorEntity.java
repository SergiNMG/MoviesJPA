package com.movies.imdb.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "directors")
@Data
@NoArgsConstructor
public class DirectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "birthyear")
    private Integer birthYear;
    @Column(name = "deathyear")
    private Integer deathYear;
}
