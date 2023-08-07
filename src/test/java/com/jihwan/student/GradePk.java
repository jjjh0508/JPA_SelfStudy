package com.jihwan.student;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradePk implements Serializable {

    @Column(name = "lect_num")
    private int lectuNum;


    @Column(name = "student_num")
    private int studentNum;


    public GradePk() {
    }

    public GradePk(int lectuNum, int studentNum) {
        this.lectuNum = lectuNum;
        this.studentNum = studentNum;
    }

    public int getLectuNum() {
        return lectuNum;
    }

    public void setLectuNum(int lectuNum) {
        this.lectuNum = lectuNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradePk gradePk = (GradePk) o;
        return lectuNum == gradePk.lectuNum && studentNum == gradePk.studentNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectuNum, studentNum);
    }
}
