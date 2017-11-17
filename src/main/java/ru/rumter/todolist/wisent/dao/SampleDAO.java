package ru.rumter.todolist.wisent.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleDAO {

    private final JdbcTemplate jdbcTemplate;

    public SampleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getData(int id) {
        return jdbcTemplate.queryForObject("SELECT data FROM sample_table WHERE id=?", String.class, id);
    }

}
