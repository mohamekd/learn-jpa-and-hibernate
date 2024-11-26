package com.kood.springboot.learn_jpa_hibernate.course;

import com.kood.springboot.learn_jpa_hibernate.course.jpa.CourseJpaRepository;
import com.kood.springboot.learn_jpa_hibernate.course.spring_jpa.CourseSpringDataJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    CourseJdbcRepo jdbcRepo;
//    @Autowired
//    CourseJpaRepository jpaRepo;
    @Autowired
    CourseSpringDataJpaRepo springDataJpaRepo;


    @Override
    public void run(String... args) throws Exception {
        /* jdbc */
//        jdbcRepo.insert(new Course(1, "Learn Spring", "Kood"));
//        jdbcRepo.insert(new Course(2, "Learn DevOps", "Medo"));
//        jdbcRepo.insert(new Course(3, "Learn Graphic", "soha"));
//        jdbcRepo.deleteById(2);
//        jdbcRepo.findByID(1);
//        System.out.println(jdbcRepo.findAll());
        /* jpa */
//        jpaRepo.insert(new Course(1, "Learn Spring", "Kood"));
//        jpaRepo.insert(new Course(2, "Learn DevOps", "Medo"));
//        jpaRepo.insert(new Course(3, "Learn Graphic", "soha"));
//        jpaRepo.deleteById(2);
//        System.out.println(jpaRepo.findById(1));
//        System.out.println(jpaRepo.findById(3));
        /* spring jpa */
        springDataJpaRepo.save(new Course(1, "Learn Spring", "Kood"));
        springDataJpaRepo.save(new Course(2, "Learn DevOps", "Medo"));
        springDataJpaRepo.save(new Course(3, "Learn Graphic", "soha"));
        springDataJpaRepo.deleteById(2L);
        System.out.println(springDataJpaRepo.findById(1L));
        System.out.println(springDataJpaRepo.findById(3L));
        System.out.println(springDataJpaRepo.findAll());
        System.out.println(springDataJpaRepo.count());
        System.out.println(springDataJpaRepo.findByAuthor("Kood"));
        System.out.println(springDataJpaRepo.findByName("Learn Graphic"));
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
