package com.kood.springboot.learn_jpa_hibernate.course.jdbc;

import com.kood.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    CourseJdbcRepo jdbcRepo;

    @Override
    public void run(String... args) throws Exception {
        jdbcRepo.insert(new Course(1, "Learn Spring", "Kood"));
        jdbcRepo.insert(new Course(2, "Learn DevOps", "Medo"));
        jdbcRepo.insert(new Course(3, "Learn Graphic", "soha"));
        jdbcRepo.deleteById(2);
        jdbcRepo.findByID(1);
        System.out.println(jdbcRepo.findAll());
    }
//    @RequestMapping("/courses")
//    public List<CourseJdbcRepo> retrieveAllCourses(){
//        return Arrays.asList(
//                new CourseJdbcRepo(1,"English CourseJdbcRepo","Medo"),
//                new CourseJdbcRepo(2,"DevOps CourseJdbcRepo","Kood"),
//                new CourseJdbcRepo(3,"Graphic CourseJdbcRepo","Soha")
//        );
//    }

}
