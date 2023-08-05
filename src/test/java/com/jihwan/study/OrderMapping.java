package com.jihwan.study;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "study_order_mapping")
@Table(name = "stu_order_mapping")

public class OrderMapping {


    @EmbeddedId
    private OrderPk orderPk;

    @MapsId("productNum")
    //@MapsId는 FK를 PK로 지정할 때 사용하는 어노테이션이다.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_num")
    public Product product;


    @MapsId("orderNum")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_num")
    private Order order;


    public OrderMapping() {
    }

    public OrderMapping(OrderPk orderPk, Order order) {
        this.orderPk = orderPk;
        this.order = order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPk);
    }

    public OrderPk getOrderPk() {
        return orderPk;
    }

    public void setOrderPk(OrderPk orderPk) {
        this.orderPk = orderPk;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "OrderMapping{" +
                "orderPk=" + orderPk +
                ", order=" + order +
                '}';
    }
}
