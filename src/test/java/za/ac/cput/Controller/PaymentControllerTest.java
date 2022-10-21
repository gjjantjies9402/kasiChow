/**PaymentControllerTest.java
 * Test Controller for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
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
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class PaymentControllerTest {
    private static Payment payment1 = PaymentFactory.createPayment("Cash on delivery", "R123456");
    private static Payment payment2 = PaymentFactory.createPayment("Card", "R123457");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/payment";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment2 , Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        payment2 = postResponse.getBody();
        System.out.println("Saved: " + payment2);
        assertEquals(payment2.getPaymentType(), postResponse.getBody().getPaymentType());
    }

    @Test
    void read() {
        String url = baseURL + "/read" + payment1.getPaymentType();
        System.out.println("Url:" + url);
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertEquals(payment2.getPaymentType(), response.getBody().getPaymentType());
    }

    @Test
    void update() {
        Payment update = new Payment.Builder().copy(payment2).setPaymentType("Cash on delivery").build();
        String url = baseURL + "/update";
        System.out.println("Update:" + update);
        ResponseEntity<Payment> response = restTemplate.postForEntity(url, update, Payment.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + payment1.getReceiptID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getAll/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Payment> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Display All: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}