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
import za.ac.cput.Entity.Ratings;
import za.ac.cput.Factory.RatingsFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class RatingsControllerTest {

    private static Ratings ratings = RatingsFactory.createRatings(8868, "ORD98", 5, "Service was great!" );

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/ratings/";


    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Ratings> postResponse = restTemplate.postForEntity(url, ratings, Ratings.class);
        System.out.println(postResponse);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        ratings = postResponse.getBody();
        System.out.println("Saved data\n----------\n" + ratings);
        assertEquals(ratings.getOrderID(), postResponse.getBody().getOrderID());
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + ratings.getOrderID();
        ResponseEntity<Ratings> response =
                restTemplate.getForEntity(
                        url,
                        Ratings.class
                );
        assertNotNull(response.getBody());
        assertEquals(ratings.getOrderID(), response.getBody().getOrderID());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Ratings updated =
                new Ratings.Builder().setOrderID("ORD69").build();
        String url = baseURL + "/update";
        ResponseEntity<Ratings> response =
                restTemplate.postForEntity(
                        url,
                        updated,
                        Ratings.class
                );
        assertNotNull(response.getBody());
        System.out.println("Updated data\n------------\n" + updated);
    }

    @Test
    void delete() {
        String url = baseURL+"/delete/"+ ratings.getOrderID() ;
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
        System.out.println("Rating");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}