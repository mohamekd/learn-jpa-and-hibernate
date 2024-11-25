package com.kood.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  static String  INSERT_QUERY = """
                insert into course(id,name,author)
                values(1,'Learn Spring','in28Mins');
                """;
    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }

}
