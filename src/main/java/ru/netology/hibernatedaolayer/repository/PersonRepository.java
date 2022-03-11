package ru.netology.hibernatedaolayer.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.netology.hibernatedaolayer.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PersonRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Person> getPersonsByCity(String city) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("city", city);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM person where city_of_living = :city", namedParameters,
                (resultSet, i) ->
                        new Person(resultSet.getString("name"), resultSet.getString("surname"),
                                resultSet.getInt("age"), resultSet.getInt("phone_number"),
                                resultSet.getString("city_of_living")));
    }
}