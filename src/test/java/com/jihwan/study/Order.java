package com.jihwan.study;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "study_order")
@Table(name = "stu_order")
public class Order {

    @Id
    @Column(name = "order_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNum;

    @Column(name = "or_status")
    private String status;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "order_modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    @Column(name = "order_delete_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

    //연관관계를 맞는건 라이프사이클을 묶는다
    @JoinColumn(name = "memberNo") //주문 정보에 회원 정보를 가져올 수있다
    @ManyToOne   // 주문은 하나의 멤버를 참조
    private Member memberNo;

    public Order() {
    }

    public Order(int orderNum, String status, Date orderDate, Date modifyDate, Date deleteDate) {
        this.orderNum = orderNum;
        this.status = status;
        this.orderDate = orderDate;
        this.modifyDate = modifyDate;
        this.deleteDate = deleteDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", modifyDate=" + modifyDate +
                ", deleteDate=" + deleteDate +
                '}';
    }
}
