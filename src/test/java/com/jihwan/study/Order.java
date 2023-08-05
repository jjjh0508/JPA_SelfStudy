package com.jihwan.study;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "memberNo") //주문 정보에 회원 정보를 가져올 수있다
//    @ManyToOne   // 주문은 하나의 멤버를 참조
    private int memberNo;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    /*
     * CascadeType.ALL: 모든 Cascade를 적용
     * CascadeType.PERSIST: 엔티티를 영속화할 때, 연관된 엔티티도 함께 유지
     * CascadeType.MERGE: 엔티티 상태를 병합(Merge)할 때, 연관된 엔티티도 모두 병합
     * CascadeType.REMOVE: 엔티티를 제거할 때, 연관된 엔티티도 모두 제거
     * CascadeType.DETACH: 부모 엔티티를 detach() 수행하면, 연관 엔티티도 detach()상태가 되어 변경 사항 반영 X
     * CascadeType.REFRESH: 상위 엔티티를 새로고침(Refresh)할 때, 연관된 엔티티도 모두 새로고침
     *
     * */
    private List<OrderMapping> orderMappings;

    public Order() {
    }

    public Order(int orderNum, String status, Date orderDate, Date modifyDate, Date deleteDate, int memberNo, List<OrderMapping> orderMappings) {
        this.orderNum = orderNum;
        this.status = status;
        this.orderDate = orderDate;
        this.modifyDate = modifyDate;
        this.deleteDate = deleteDate;
        this.memberNo = memberNo;
        this.orderMappings = orderMappings;
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public List<OrderMapping> getOrderMappings() {
        return orderMappings;
    }

    public void setOrderMappings(List<OrderMapping> orderMappings) {
        this.orderMappings = orderMappings;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", modifyDate=" + modifyDate +
                ", deleteDate=" + deleteDate +
                ", memberNo=" + memberNo +
                ", orderMappings=" + orderMappings +
                '}';
    }
}
