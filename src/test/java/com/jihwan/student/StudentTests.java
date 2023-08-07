package com.jihwan.student;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTests {

    private static EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        managerFactory = Persistence.createEntityManagerFactory("jpatest");
    }


    @BeforeEach
    public void initManager() {
        entityManager = managerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory(){
        managerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }


    @Test
    @Order(1)
    void 학생_등록_테스트() {
        Student student = new Student();
        student.name("고민영").address("김포").phone("010-2323-2322").builder();

        EntityTransaction entityTransaction  = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(student);
        entityTransaction.commit();

        Student findStudent1 = entityManager.find(Student.class,student.getStudentNum());
        System.out.println(findStudent1);
        Assertions.assertEquals(student.getStudentNum(),findStudent1.getStudentNum());

    }

    @Test
    @Order(2)
    void 과목_등록_테스트() {
        Lectures lectures = new Lectures();
        lectures.lectuName("자바").builder();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(lectures);
        entityTransaction.commit();
        Lectures lectures1 = entityManager.find(Lectures.class,lectures.getLectuNum());
        Assertions.assertEquals(lectures,lectures1);
        System.out.println(lectures1);

    }

    @Test
    @Order(3)
    void 학점_등록_테스트() {
        Grade grade = new Grade();
        Student student = entityManager.find(Student.class,1);
        Lectures lectures = entityManager.find(Lectures.class,1);

        System.out.println(student);
        System.out.println(lectures);
        grade.gradePk(new GradePk(student.getStudentNum(),lectures.getLectuNum()));
        grade.semester(1).lectuScore(100).builder();
        System.out.println(grade);
        EntityTransaction entityTransaction  = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(grade);
        entityTransaction.commit();

        Grade findGrade1 = entityManager.find(Grade.class,new GradePk(student.getStudentNum(),lectures.getLectuNum()));
        Assertions.assertEquals(grade,findGrade1);
    }


    @Test
    @Order(4)
    void 학생_학점테스트() {
        Student student = entityManager.find(Student.class,1);
        System.out.println(student);
    }
}
