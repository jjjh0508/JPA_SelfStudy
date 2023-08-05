package com.jihwan.study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderMappingTests {

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
//    @DisplayName("회원 테이블 등록및 테스트")
    void 회원_생성_테스트() {
        //given
        Member member = new Member();
        member.setName("전지환");
        member.setNickName("지환");
        member.setAddressNum("10068");
        member.setAddress("경기도 김포");
        member.setDetailAddress("우리집 아파트");
        member.setRoleType(RoleType.MEMBER);
        member.setCreateDate(new Date());
        member.setStatus("Y");

        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member);
        System.out.println(member.getMemberNo());

        try {
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        //then
        Member findMember = entityManager.find(Member.class, 1);
        Assertions.assertEquals(member.getMemberNo(), findMember.getMemberNo());

    }

    @Test
    @Order(2)
    void 제품_등록_테스트() {
        Product product = new Product();
        product.setProductName("갤럭시");
        product.setProductPrice("100000");

        entityManager.persist(product);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityTransaction.commit();

        Product findProduct1 = entityManager.find(Product.class, product.getProductNum());
        Assertions.assertEquals(product.getProductNum(),findProduct1.getProductNum());


    }

    @Test
    @Order(3)
    void 주문_등록_테스트() {
        //제품을 찾고
        Product findProduct = entityManager.find(Product.class, 1);
        //회원을 찾고
        Member findMember = entityManager.find(Member.class, 1);

        //주문등록
        com.jihwan.study.Order order = new com.jihwan.study.Order();
        //제품에 회원번호
        order.setMemberNo(findMember.getMemberNo());


        //주문리스트 추가
        OrderMapping orderMapping = new OrderMapping();
        orderMapping.setOrderPk(new OrderPk(order.getOrderNum(),findProduct.getProductNum()));
        orderMapping.setOrder(order);
        orderMapping.setProduct(findProduct);

        List<OrderMapping> orderMappingList = new ArrayList<>();

        orderMappingList.add(orderMapping);

        order.setOrderMappings(orderMappingList);


        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(order);
        entityTransaction.commit();

        System.out.println(order);
        com.jihwan.study.Order findOrder1 = entityManager.find(com.jihwan.study.Order.class,order.getOrderNum());
        Assertions.assertEquals(order,findOrder1);



    }


}
