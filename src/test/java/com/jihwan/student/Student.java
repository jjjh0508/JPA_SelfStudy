package com.jihwan.student;

import javax.persistence.*;
import java.util.List;

//학생
@Entity(name = "stu_student")
@Table(name = "stu_stidemt")
public class Student {

    @Id
    @Column(name = "student_num", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentNum;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;



    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Student() {
    }


    public Student(int studentNum, String name, String phone, String address, List<Grade> grades) {
        this.studentNum = studentNum;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.grades = grades;
    }

    public Student studentNum(int studentNum) {
        this.studentNum = studentNum;
        return this;
    }


    public Student name(String name) {
        this.name = name;
        return this;
    }

    public Student phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Student address(String address) {
        this.address = address;
        return this;
    }

    public Student builder() {
        return new Student(studentNum, name, phone, address,grades);
    }


    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", grades=" + grades +
                '}';
    }
}
