package io.github.seebaware.jdbctemplate.movie;

import io.github.seebaware.jdbctemplate.actor.Actor;

import java.util.List;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    String releaseDate) {
}
