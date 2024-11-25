package com.kood.springboot.learn_jpa_hibernate.course.jdbc;

import com.kood.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

}
