package io.github.seebaware.shark.movie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                null,
                resultSet.getString("releaseDate")
        );

    }

   /* private LocalDateTime formatDateTime(String releaseDate) {
        return
                LocalDateTime.parse(resultSet.getString("releaseDate"));
    }*/

}