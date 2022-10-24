//package za.ac.cput.Controller;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import za.ac.cput.Entity.Order;
//import za.ac.cput.Factory.OrderFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//class OrderControllerTest {
//
//    private static Order order = OrderFactory.createOrder(1416, "ORD98","DRV25", 10, "Delivered", "14:32");
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private  String baseURL = "http://localhost:8080/order/";
//
//
//    @Test
//    void create() {
//        String url = baseURL + "/create";
//        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        order = postResponse.getBody();
//        System.out.println("Order \n----------\n" + order);
//        assertEquals(order.getOrderID(), postResponse.getBody().getOrderID());
//
//    }
//
//    @Test
//    void read() {
//        String url = baseURL + "/read/" + order.getTrackStatus();
//        System.out.println("URL: " + url);
//        ResponseEntity<Order> response =
//                restTemplate.getForEntity(
//                        url,
//                        Order.class
//                );
//        assertNotNull(response.getBody());
//        assertEquals(order.getTrackStatus(), response.getBody().getTrackStatus());
//
//    }
//
//    @Test
//    void update() {
//        Order updated = new Order.Builder().copy(order).setOrderID("ORD94").build();
//        String url = baseURL + "/update";
//        System.out.println("Updated data\n------------\n" + updated);
//        ResponseEntity<Order> response =
//                restTemplate.postForEntity(
//                        url,
//                        updated,
//                        Order.class
//                );
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    void delete() {
//        String url = baseURL+"/delete/"+order.getOrderID() ;
//        System.out.println("URL: "+url);
//        restTemplate.delete(url);
//
//    }
//
//    @Test
//    void getAll() {
//        String url = baseURL+"/getall";
//        org.springframework.http.HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Order> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("Orders: ");
//        System.out.println(response);
//        System.out.println(response.getBody());
//
//    }
//}