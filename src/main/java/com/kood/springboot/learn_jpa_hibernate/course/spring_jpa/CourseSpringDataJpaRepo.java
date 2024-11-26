package com.kood.springboot.learn_jpa_hibernate.course.spring_jpa;

import com.kood.springboot.learn_jpa_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepo extends JpaRepository<Course, Long> {

    // custom methods :
    public List<Course> findByAuthor(String author);
    public List<Course> findByName(String name);

}
