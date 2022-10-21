package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class OrderItemControllerTest {

    private static OrderItem oItem = OrderItemFactory.createOrderItem("001", 1, 28.99);
    private static OrderItem oItem1 = OrderItemFactory.createOrderItem("039", 15, 528.99);
    private static OrderItem oItem2 = OrderItemFactory.createOrderItem("020", 7, 128.99);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/orderItem/";

    public static OrderItem getOrderItem() {

        return oItem;
    }

    public static void setOrderItem(OrderItem orderItem) {
        OrderItemControllerTest.oItem = orderItem;
    }

    @Test
    public void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, oItem, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        oItem = postResponse.getBody();
        System.out.println("Created: " + oItem);
        assertEquals(oItem.getItemID(), postResponse.getBody().getItemID());
    }

    @Test
    public void b_read() {
        String url = baseURL + "/read/" + oItem.getItemID();
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem> orderItemResponse = restTemplate.getForEntity(url, OrderItem.class);
        assertEquals(oItem.getItemID(), orderItemResponse.getBody().getItemID());
    }

    @Test
    public void c_update() {
        String url = baseURL + "update";
        OrderItem updated = new OrderItem.Builder().copy(oItem).setQuantity(5).build();
        System.out.println("URL: " + url);
        System.out.println("Updated: " + updated);
        ResponseEntity<OrderItem> orderItemResponse = restTemplate.postForEntity(url, updated, OrderItem.class);
        assertNotNull(orderItemResponse.getBody());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "/getall/";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> orderItemEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> orderItemResponse = restTemplate.exchange(url, HttpMethod.GET, orderItemEntity, String.class);
        System.out.println("Show All: ");
        System.out.println(orderItemResponse);
        System.out.println(orderItemResponse.getBody());
    }

    @Test
    public void delete() {
        String url = baseURL + "/delete/" + oItem1.getItemID();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }


}
//