package io.github.seebaware.shark.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {

        var sql = """
                SELECT id, name, releaseDate
                FROM movie
                LIMIT 100;
                """;

        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        String sql = """
                INSERT INTO movie(id, name, releaseDate)
                VALUES (?, ?, ?);
                """;
        return jdbcTemplate.update(sql,
                movie.id(),
                movie.name(),
                movie.releaseDate()
        );
    }

    @Override
    public int deleteMovie(int id) {

        var sql = """
                DELETE FROM movie
                WHERE id = ?
        """;

        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = """
                SELECT id, name, releaseDate
                FROM movie
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }

}
