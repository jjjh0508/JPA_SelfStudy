package com.jihwan.student;

//과목

import javax.persistence.*;

@Entity(name = "student_lectures")
@Table(name = "stu_lectures")
public class Lectures {

    @Id
    @Column(name = "lect_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lectuNum;


    @Column(name = "lectu_name",nullable = false)
    private String lectuName;


    public Lectures() {
    }

    public Lectures(int lectuNum, String lectuName) {
        this.lectuNum = lectuNum;
        this.lectuName = lectuName;
    }

    public Lectures lectuNum(int lectuNum) {
        this.lectuNum = lectuNum;
        return this;
    }

    public Lectures lectuName(String lectuName) {
        this.lectuName = lectuName;
        return  this;
    }

    public Lectures builder() {
        return new Lectures( lectuNum,  lectuName);
    }


    public int getLectuNum() {
        return lectuNum;
    }

    public void setLectuNum(int lectuNum) {
        this.lectuNum = lectuNum;
    }

    public String getLectuName() {
        return lectuName;
    }

    public void setLectuName(String lectuName) {
        this.lectuName = lectuName;
    }

    @Override
    public String toString() {
        return "Lectures{" +
                "lectuNum=" + lectuNum +
                ", lectuName='" + lectuName + '\'' +
                '}';
    }
}
