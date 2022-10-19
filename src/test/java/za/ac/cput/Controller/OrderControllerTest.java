package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Order;
import za.ac.cput.Factory.OrderFactory;

import java.net.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    private static Order order = OrderFactory.createOrder(1416, "ORD98","DRV25", 10, "Delivered", "14:32");

    @Autowired
    private TestRestTemplate restTemplate;
    private  String baseURL = "http://localhost:8080/order/";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        System.out.println(postResponse);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        order = postResponse.getBody();
        System.out.println("Saved data\n----------\n" + order);
        assertEquals(order.getOrderID(), postResponse.getBody().getOrderID());
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + order.getTrackStatus();
        ResponseEntity<Order> response =
                restTemplate.getForEntity(
                        url,
                        Order.class
                );
        assertNotNull(response.getBody());
        assertEquals(order.getTrackStatus(), response.getBody().getTrackStatus());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Order updated =
                new Order.Builder().setOrderID("ORD94").build();
        String url = baseURL + "/update";
        ResponseEntity<Order> response =
                restTemplate.postForEntity(
                        url,
                        updated,
                        Order.class
                );
        assertNotNull(response.getBody());
        System.out.println("Updated data\n------------\n" + updated);
    }

    @Test
    void delete() {
        String url = baseURL+"/delete/"+order.getOrderID() ;
        System.out.println("URL: "+url);
        restTemplate.delete(url);
//        String urlDelete = baseURL + "/delete/" + order.getOrderNr();
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity =  new HttpEntity<>(null, headers);
//        ResponseEntity<Boolean> isDeleted =
//                restTemplate.exchange(
//                        urlDelete,
//                        HttpMethod.DELETE,
//                        entity,
//                        boolean.class
//                );
//        assertNotNull(isDeleted.getBody());
//        assertTrue(isDeleted.getBody());
//        String urlRead = baseURL + "/read/" + order.getOrderNr();
//        ResponseEntity<Order> response =
//                restTemplate.getForEntity(
//                        urlRead,
//                        Order.class
//                );
//        assertNull(response.getBody());
    }

    @Test
    void getAll() {
        String url = baseURL+"/getall";
        System.out.println("URL: " + url);
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Order");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}