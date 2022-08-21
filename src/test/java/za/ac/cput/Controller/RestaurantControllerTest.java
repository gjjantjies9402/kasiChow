package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestaurantControllerTest {

     private static Restaurant res = RestaurantFactory.buildRestaurant("Shop 012","McDonalds","Tygervalley Center" );

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/restaurant/";

    @Test
    public void a_created(){
        String url = baseURL + "create";
        ResponseEntity<Restaurant> postResponse = restTemplate.postForEntity(url, res, Restaurant.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        res = postResponse.getBody();
        System.out.println("Created data" + res);
        assertNotNull(res.getRestaurantId(), postResponse.getBody().getRestaurantId());
    }


    @Test
    public  void b_read(){
        String url = baseURL + "read/" + res.getRestaurantId();
        System.out.println("URL: " + url);
        ResponseEntity<Restaurant> restaurantResponse = restTemplate.getForEntity(url, Restaurant.class);
        assertEquals(res.getRestaurantId(), restaurantResponse.getBody().getRestaurantId());
    }

    @Test
    public  void  c_update(){
        String url = baseURL + "update";
        Restaurant updated = new Restaurant.Builder().copy(res).setRestaurantName("NEW NAME").build();
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        ResponseEntity<Restaurant> restaurantResponse = restTemplate.postForEntity(url, updated, Restaurant.class);
        assertNotNull(res.getRestaurantId(), restaurantResponse.getBody().getRestaurantId());

    }


    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> restaurantEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> restaurantResponse = restTemplate.exchange(url, HttpMethod.GET, restaurantEntity, String.class);
        System.out.println(restaurantResponse);
        System.out.println(restaurantResponse.getBody());
    }
    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + res.getRestaurantId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}