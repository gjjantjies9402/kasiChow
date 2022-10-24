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
import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Factory.SupermarketFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupermarketControllerTest {

    private static Supermarket mar = SupermarketFactory.buildSupermarket("Shop 3a", "FoodLovers", " Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550");
    private static Supermarket mar2 = SupermarketFactory.buildSupermarket("Shop 4a", "Cardies", " Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8090/supermarket";

    @Test
    public void create(){
        String url = baseURL + "/create";
        ResponseEntity<Supermarket> postResponse = restTemplate.postForEntity(url, mar2, Supermarket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        mar2 = postResponse.getBody();
        System.out.println("Created data" + mar2);
        assertEquals(mar2.getMarketId(), postResponse.getBody().getMarketId());
    }



    @Test
    public  void read(){
        String url = baseURL + "/read/" + mar.getMarketId();
        System.out.println("URL: " + url);
        ResponseEntity<Supermarket> supermarketResponse = restTemplate.getForEntity(url, Supermarket.class);
        assertEquals(mar.getMarketId(), Objects.requireNonNull(supermarketResponse.getBody()).getMarketId());
    }

    @Test
    public  void  update(){
        String url = baseURL + "/update/";
        Supermarket updated = new Supermarket.Builder().copy(mar).setMarketName("New Market name").build();
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Supermarket> supermarketResponse = restTemplate.postForEntity(url, updated, Supermarket.class);
        assertEquals(mar.getMarketId(), supermarketResponse.getBody().getMarketId());
    }
    @Test
    public void getAll(){
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> supermarketEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> supermarketResponse = restTemplate.exchange(url, HttpMethod.GET, supermarketEntity, String.class);
        System.out.println(supermarketResponse);
        System.out.println(supermarketResponse.getBody());
    }
    @Test
    public void delete(){
        String url = baseURL + "/delete/" + mar.getMarketId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}