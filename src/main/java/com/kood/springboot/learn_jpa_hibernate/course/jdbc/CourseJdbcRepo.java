package com.kood.springboot.learn_jpa_hibernate.course.jdbc;

import com.kood.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CourseJdbcRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*Hard Coded Query*/
//    private  static String  INSERT_QUERY = """
//                insert into course(id,name,author)
//                values(1,'Learn Spring','Kood');
//                """;
//    public void insert(){
//        jdbcTemplate.update(INSERT_QUERY);
//    }

    /*NOT Hard Coded Query*/
    private static String INSERT_QUERY = """
            insert into course(id,name,author)
            values(?,?,?);
            """;

    private static String SELECT_QUERY = """
            SELECT * from course;
            """;

    private static String SELECT_BY_ID_QUERY = """
            SELECT from course WHERE id = ?;
            """;
    private static String DELETE_QUERY = """
            DELETE from course WHERE id = ?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public Course findByID(long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.queryForList(SELECT_QUERY);
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

}
