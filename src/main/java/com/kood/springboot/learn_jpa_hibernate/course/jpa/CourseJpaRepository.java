package com.kood.springboot.learn_jpa_hibernate.course.jpa;

import com.kood.springboot.learn_jpa_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    private Class<Course> persistentClass;
    @PersistenceContext
    EntityManager manager;

    public void insert(Course course) {
        manager.merge(course);
    }

    public Course findById(long id) {
        return manager.find(Course.class,id);
    }

    public void deleteById(long id) {
        Course c = findById(id);
        if (c == null)
            System.out.println("err 404 : not found");
        else {
            manager.remove(c);
            System.out.println("successfully removed");
        }
    }

}
