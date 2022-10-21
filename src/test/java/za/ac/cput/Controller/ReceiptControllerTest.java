/**ReceiptControllerTest.java
 * Test Controller for Receipt
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
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReceiptControllerTest {
    private static Receipt receipt1 = ReceiptFactory.createReceipt("R123456","OR456","D0987","C657", 650 );
    private static Receipt receipt2 = ReceiptFactory.createReceipt("R123457","OR457","D0988","C658", 750 );

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/receipt";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Receipt> postResponse = restTemplate.postForEntity(url, receipt2 , Receipt.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        receipt2 = postResponse.getBody();
        System.out.println("Saved: " + receipt2);
        assertEquals(receipt2.getReceiptID(), postResponse.getBody().getReceiptID());

    }

    @Test
    void read() {
        String url = baseURL + "/read" + receipt1.getReceiptID();
        System.out.println("Url:" + url);
        ResponseEntity<Receipt> response = restTemplate.getForEntity(url, Receipt.class);
        assertEquals(receipt2.getReceiptID(), response.getBody().getReceiptID());

    }

    @Test
    void update() {
        Receipt update = new Receipt.Builder().copy(receipt2).setAmountPaid(1000).build();
        String url = baseURL + "/update";
        System.out.println("Update:" + update);
        ResponseEntity<Receipt> response = restTemplate.postForEntity(url, update, Receipt.class);
        assertNotNull(response.getBody());


    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + receipt1.getReceiptID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getAll/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Receipt> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Display All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}