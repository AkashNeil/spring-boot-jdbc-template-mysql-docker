package io.github.seebaware.shark.movie;

import io.github.seebaware.shark.actor.Actor;

import java.util.List;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    String releaseDate) {
}
