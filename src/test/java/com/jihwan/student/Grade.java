package com.jihwan.student;

//학점

import javax.persistence.*;

@Entity(name = "student_grade")
@Table(name = "stu_grade")
public class Grade {

    @EmbeddedId
    private GradePk gradePk;

//    @MapsId("lectuNum")
//    @ManyToOne
//    @JoinColumn (name = "lect_num")
//    private int lectuNum;  //fk


//    private  int studentNum; // fk


    @Column(name = "semester",nullable = false)
    private int semester; // 학기

    @Column(name = "lectu_score",nullable = false)
    private int lectuScore; // 과목점수

    public Grade() {
    }

    public Grade(GradePk gradePk, int semester, int lectuScore) {
        this.gradePk = gradePk;
        this.semester = semester;
        this.lectuScore = lectuScore;
    }

    //    public Grade lectuNum(int lectuNum) {
//        this.lectuNum = lectuNum;
//        return this;
//    }
//
//    public Grade studentNum(int studentNum) {
//        this.studentNum = studentNum;
//        return this;
//    }

    public Grade semester(int semester) {
        this.semester = semester;
        return this;
    }
    public Grade gradePk(GradePk gradePk) {
        this.gradePk = gradePk;
        return this;
    }

    public Grade lectuScore(int lectuScore) {
        this.lectuScore =lectuScore;
        return this;
    }

    public Grade builder() {
        return new Grade( gradePk,   semester,  lectuScore);
    }


    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getLectuScore() {
        return lectuScore;
    }

    public void setLectuScore(int lectuScore) {
        this.lectuScore = lectuScore;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradePk=" + gradePk +
                ", semester=" + semester +
                ", lectuScore=" + lectuScore +
                '}';
    }
}
