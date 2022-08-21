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
import za.ac.cput.Entity.Tracking;
import za.ac.cput.Factory.TrackingFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrackingControllerTest {

    private static Tracking tracking = TrackingFactory.createTracking("ORD98", 2568, "Complete");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/tracking";


    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Tracking> postResponse = restTemplate.postForEntity(url, tracking, Tracking.class);
        System.out.println(postResponse);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        tracking = postResponse.getBody();
        System.out.println("Saved data\n----------\n" + tracking);
        assertEquals(tracking.getOrderNr(), postResponse.getBody().getOrderNr());
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + tracking.getOrderNr();
        ResponseEntity<Tracking> response =
                restTemplate.getForEntity(
                        url,
                        Tracking.class
                );
        assertNotNull(response.getBody());
        assertEquals(tracking.getOrderNr(), response.getBody().getOrderNr());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Tracking updated =
                new Tracking.Builder().setOrderNr("ORD69").build();
        String url = baseURL + "/update";
        ResponseEntity<Tracking> response =
                restTemplate.postForEntity(
                        url,
                        updated,
                        Tracking.class
                );
        assertNotNull(response.getBody());
        System.out.println("Updated data\n------------\n" + updated);
    }

    @Test
    void delete() {
        String url = baseURL+"/delete/"+tracking.getOrderNr() ;
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL+"/getall";
        System.out.println("URL: " + url);
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Tracking");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}