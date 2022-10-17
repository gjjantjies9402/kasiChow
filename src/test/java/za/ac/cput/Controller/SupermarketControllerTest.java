package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Factory.SupermarketFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SupermarketControllerTest {

    private static Supermarket mar = SupermarketFactory.buildSupermarket("Shop 3a", "FoodLovers", " Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/supermarket/";

    @Test
    public void a_created(){
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + mar);
        ResponseEntity<Supermarket> postResponse = restTemplate.postForEntity(url, mar, Supermarket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        mar = postResponse.getBody();
        System.out.println("Created data" + mar);
        assertEquals(mar.getMarketId(), postResponse.getBody().getMarketId());
    }



    @Test
    public  void b_read(){
        String url = baseURL + "read/" + mar.getMarketId();
        System.out.println("URL: " + url);
        ResponseEntity<Supermarket> supermarketResponse = restTemplate.getForEntity(url, Supermarket.class);
        assertEquals(mar.getMarketId(), supermarketResponse.getBody().getMarketId());
    }

    @Test
    public  void  c_update(){
        String url = baseURL + "update";
        Supermarket updated = new Supermarket.Builder().copy(mar).setMarketName("New Market name").build();
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Supermarket> supermarketResponse = restTemplate.postForEntity(url, updated, Supermarket.class);
        assertEquals(mar.getMarketId(), supermarketResponse.getBody().getMarketId());
    }
    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> supermarketEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> supermarketResponse = restTemplate.exchange(url, HttpMethod.GET, supermarketEntity, String.class);
        System.out.println(supermarketResponse);
        System.out.println(supermarketResponse.getBody());
    }
    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + mar.getMarketId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}