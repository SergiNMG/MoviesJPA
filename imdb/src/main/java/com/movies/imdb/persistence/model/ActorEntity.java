package com.movies.imdb.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "actors")
@Data
@NoArgsConstructor
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "birthyear")
    private Integer birthYear;
    @Column(name = "deathyear")
    private Integer deathYear;
}
