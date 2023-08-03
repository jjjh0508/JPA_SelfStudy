package com.jihwan.study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTests {
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
    public static void closeFactory() {
        managerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }


    @Test
    @Order(1)
    void 제품_등록_테스트() {

        //given
        Product product = new Product();
        product.setProductName("갤럭시 폴드");
        product.setProductPrice("2000000");


        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(product);
        System.out.println(product.getProductNum());
        try {
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }

        //then
    Product findProduct1 = entityManager.find(Product.class,product.getProductNum());

    Assertions.assertEquals(product,findProduct1);

    }

    @Test
    @Order(2)
    void 제품_조회_테스트() {


        Product findProduct1 = entityManager.find(Product.class,0);
        System.out.println(findProduct1);
        System.out.println(findProduct1);
        Assertions.assertNotNull(findProduct1);
    }

    @Test
    @Order(3)
    void 주문_등록_테스트() {
        com.jihwan.study.Order order = new com.jihwan.study.Order();
        order.setStatus("Y");
        order.setOrderDate(new Date());

        entityManager.persist(order);
        System.out.println(order.getOrderNum());
        Product findProduct1 = entityManager.find(Product.class,0);
        OrderMapping orderMapping = new OrderMapping();


        EntityTransaction  entityTransaction = entityManager.getTransaction();
        System.out.println(order.getOrderNum());
        entityTransaction.begin();
        entityTransaction.commit();
        orderMapping.setOrderPk(new OrderPk(order.getOrderNum(),findProduct1.getProductNum()));
        entityManager.persist(orderMapping);

        Assertions.assertEquals(order.getOrderNum(),orderMapping.getOrderPk().getOrderNum());

    }


    @Test
    @Order(4)
    void 주문_삭제_테스트() {
        //given
        com.jihwan.study.Order order = entityManager.find(com.jihwan.study.Order.class,1);
        System.out.println("ddd"+order);
        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityManager.remove(order);
        entityTransaction.begin();

        entityTransaction.commit();

        //then

        com.jihwan.study.Order  findOrder = entityManager.find(com.jihwan.study.Order.class,order.getOrderNum());
        Assertions.assertNull(findOrder);


    }
}
